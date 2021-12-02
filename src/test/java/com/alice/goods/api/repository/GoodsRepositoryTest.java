package com.alice.goods.api.repository;


import com.alice.goods.api.dto.GoodsDto;
import com.alice.goods.api.entity.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class GoodsRepositoryTest {

     private @Autowired GoodsRepository goodsRepository;



    @Test
    void 단일상품조회_테스트() throws Exception {

        Goods goods = goodsRepository.selectGetGoodsInfo(1001L);

        assertTrue(goods.getComId().equals("test"));

    }

    @Test
    void 전체상품조회_테스트() throws Exception {

        Optional<Goods> found = goodsRepository.findById(1001L);
        System.out.println(found.get().getReview());
        boolean test = true;

        List<Goods> goods = goodsRepository.selectGetGoodsList();

        assertTrue(goods.size() > 0);

    }

}
