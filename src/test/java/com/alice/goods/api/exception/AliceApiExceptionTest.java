package com.alice.goods.api.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AliceApiExceptionTest {

    @Test
    void exceptionMessage() {
        Exception e1 = new AliceApiException(HttpStatus.CREATED, AliceError.FailedToCreate, null);
        assertEquals("Failed to create goods for some reason", e1.getMessage());

        Exception e2 = new AliceApiException(HttpStatus.NOT_FOUND, AliceError.NotFound, new Object[] {"alice"});
        assertEquals("alice not found.", e2.getMessage());
    }

}
