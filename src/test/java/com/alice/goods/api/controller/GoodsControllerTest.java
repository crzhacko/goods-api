package com.alice.goods.api.controller;

import com.alice.goods.api.exception.FailedToCreateGoodsException;
import com.alice.goods.api.service.GoodsService;
import com.alice.goods.api.dto.GoodsDto;
import com.alice.goods.api.exception.GoodsNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 컨트롤러 응답 테스트
 */
@SpringBootTest
@AutoConfigureMockMvc
class GoodsControllerTest {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    private final String BASE_PATH = "/v1/goods";

    private final Long goodsNo = 1L;
    private final String goodsNm = "무신사 상품";
    private final String goodsCont = "혜령이꺼";
    private final Integer price = 1000000;
    private final String goodsImg = "/musinsa/1/musinsa.jpg";
    private final String comId = "hrcorp";
    private final LocalDateTime regDm = LocalDateTime.now();
    private final LocalDateTime updDm = LocalDateTime.now();
    private GoodsDto goods;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GoodsService service;

    @BeforeEach
    void beforeEach() {
        goods = GoodsDto.builder()
                .goodsNo(goodsNo)
                .goodsNm(goodsNm)
                .goodsCont(goodsCont)
                .price(price)
                .goodsImg(goodsImg)
                .comId(comId)
                .regDm(regDm)
                .updDm(updDm)
                .build();
    }

    @Test
    void 상품등록_응답_테스트() throws Exception {
        doNothing().when(service).add(any());

        mockMvc.perform(post(BASE_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"goodsNo\": \"1\", \"goodsNm\": \"혜령이꺼\", \"price\": \"1000\", \"goodsImg\": \"1000\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$['code']").value(HttpStatus.CREATED.value()))
                .andExpect(jsonPath("$['message']").value("Goods created."))
                .andDo(print());
    }

    @Test
    void 상품등록_필수_입력_파라미터_유효성테스트() throws Exception {

        mockMvc.perform(post(BASE_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"goodsNo\": \"1\"}"))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    void 상품등록실패_응답_테스트() throws Exception {

        doThrow(new FailedToCreateGoodsException()).when(service).add(any());

        mockMvc.perform(post(BASE_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"goodsNo\": \"1\", \"goodsNm\": \"혜령이꺼\", \"price\": \"1000\", \"goodsImg\": \"1000\"}"))
                .andExpect(status().isInternalServerError())
                .andDo(print());
    }

    @Test
    void 상품수정_응답_테스트() throws Exception {
        doNothing().when(service).edit(any());

        mockMvc.perform(put(BASE_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"goodsNo\": \"1\", \"goodsNm\": \"혜령이꺼\", \"price\": \"1000\", \"goodsImg\": \"1000\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$['code']").value(HttpStatus.OK.value()))
                .andExpect(jsonPath("$['message']").value("Goods updated."))
                .andDo(print());
    }

    @Test
    void 상품삭제_응답_테스트() throws Exception {
        doNothing().when(service).remove(any());

        mockMvc.perform(delete(BASE_PATH + "/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$['code']").value(HttpStatus.OK.value()))
                .andExpect(jsonPath("$['message']").value("Goods[goodsNo=1] deleted."))
                .andDo(print());
    }

    @Test
    void 상품리스트조회_응답_테스트() throws Exception {
        List<GoodsDto> list = new ArrayList<>();
        list.add(goods);
        given(service.findAll()).willReturn(list);

        mockMvc.perform(get(BASE_PATH))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..['goodsNo']").value(1))
                .andExpect(jsonPath("$..['goodsNm']").value(goodsNm))
                .andExpect(jsonPath("$..['goodsCont']").value(goodsCont))
                .andExpect(jsonPath("$..['price']").value(price))
                .andExpect(jsonPath("$..['goodsImg']").value(goodsImg))
                .andExpect(jsonPath("$..['comId']").value(comId))
                .andExpect(jsonPath("$..['regDm']").value(regDm.format(formatter)))
                .andExpect(jsonPath("$..['updDm']").value(updDm.format(formatter)))
                .andDo(print());
    }

    @Test
    void goodsNo에_의한_상품_정보_조회_테스트() throws Exception {

        given(service.findById(goodsNo)).willReturn(goods);

        mockMvc.perform(get(BASE_PATH + "/" + goodsNo))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$['goodsNo']").value(goodsNo))
                .andExpect(jsonPath("$['goodsNm']").value(goodsNm))
                .andExpect(jsonPath("$['goodsCont']").value(goodsCont))
                .andExpect(jsonPath("$['price']").value(price))
                .andExpect(jsonPath("$['goodsImg']").value(goodsImg))
                .andExpect(jsonPath("$['comId']").value(comId))
                .andExpect(jsonPath("$['regDm']").value(regDm.format(formatter)))
                .andExpect(jsonPath("$['updDm']").value(updDm.format(formatter)))
                .andDo(print());
    }

    @Test
    void 존재하지_않는_상품_정보_조회_테스트() throws Exception {

        final Throwable expected = new GoodsNotFoundException(goodsNo);
        final String exptectedMessage = expected.getMessage();

        given(service.findById(goodsNo)).willThrow(expected);

        mockMvc.perform(get(BASE_PATH + "/" + goodsNo))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$['code']").value(1002))
                .andExpect(jsonPath("$['message']").value(exptectedMessage))
                .andDo(print());
    }
}
