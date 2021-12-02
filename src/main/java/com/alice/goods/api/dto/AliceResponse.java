package com.alice.goods.api.dto;

import lombok.Value;

@Value(staticConstructor = "of")
public class AliceResponse {

    private int code;
    private String message;

}
