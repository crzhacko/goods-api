package com.alice.goods.api.exception;

import com.alice.goods.api.util.MessageUtils;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public class AliceApiException extends RuntimeException {

    private static final String messageKeyPrefix = "error.";
    private static final long serialVersionUID = 1L;

    @Getter private HttpStatus status;
    private AliceError code;

    public AliceApiException(HttpStatus status, AliceError code, Object[] args) {
        super(MessageUtils.getMessage(messageKeyPrefix + code.getValue(), args));
        this.status = status;
        this.code = code;
    }

    public int getErrorCode() {
        return code.getValue();
    }
}
