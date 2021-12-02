package com.alice.goods.api.exception;

import org.springframework.http.HttpStatus;

public class FailedToCreateGoodsException extends AliceApiException {

    public FailedToCreateGoodsException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, AliceError.FailedToCreate, null); // unknown error
        // "Failed to create goods for some reason"
    }

}
