package com.alice.goods.api.exception;

public enum AliceError {

    FailedToCreate(1001), NotFound(1002), InvalidArguments(1003);


    private final int value;

    AliceError(int value) { this.value = value; }

    public int getValue() { return value; }
}
