package com.alice.goods.api.exception;

import org.springframework.http.HttpStatus;

public class GoodsNotFoundException extends AliceApiException {

    public GoodsNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, AliceError.NotFound, new Object[]{ "Goods[goodsNo=" + id + "]" });
    }

}
