package com.alice.goods.api.service;

import com.alice.goods.api.entity.Goods;
import com.alice.goods.api.exception.GoodsNotFoundException;
import com.alice.goods.api.mapper.GoodsMapper;
import com.alice.goods.api.repository.GoodsRepository;
import com.alice.goods.api.service.impl.GoodsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GoodsServiceTest {

    @Mock
    private GoodsRepository repository;
    @Autowired
    private GoodsMapper mapper;

    private GoodsService service; // = new GoodsServiceImpl(repository, mapper);

    // 이하 테스트 케이스
    private final Long goodsNo = 1L;
    private final String goodsNm = "무신사 상품";
    private final String goodsCont = "혜령이꺼";
    private final Integer price = 1000000;
    private final String goodsImg = "/musinsa/1/musinsa.jpg";
    private final String comId = "hrcorp";
    private final LocalDateTime regDm = LocalDateTime.now();
    private final LocalDateTime updDm = LocalDateTime.now();
    private Goods goods;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.initMocks(this);
        service = new GoodsServiceImpl(repository, mapper);

        goods = new Goods();
        goods.setGoodsNo(goodsNo);
        goods.setGoodsNm(goodsNm);
        goods.setGoodsCont(goodsCont);
        goods.setPrice(price);
        goods.setGoodsImg(goodsImg);
        goods.setComId(comId);
        goods.setRegDm(regDm);
        goods.setUpdDm(updDm);
    }

    @Test
    void goodsNo에_의한_조회() {

        when(repository.findById(goodsNo)).thenReturn(Optional.of(goods));

        assertEquals(mapper.toDto(goods), service.findById(goodsNo));
    }

    @Test
    void goodsNo에_의한_조회_NOT_FOUND() {

        when(repository.findById(any())).thenReturn(Optional.empty());

        assertThrows(
                GoodsNotFoundException.class,
                () -> service.findById(goodsNo)
        );
    }

}
