package com.alice.goods.api.repository;


import com.alice.goods.api.dto.GoodsDto;
import com.alice.goods.api.entity.Goods;

import java.util.List;

public interface GoodsRepositoryCustom {
    Goods selectGetGoodsInfo(Long goodsNo);
    List<Goods> selectGetGoodsList();

}
