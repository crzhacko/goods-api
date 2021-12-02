package com.alice.goods.api.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageUtilsTest {

    @Test
    void getMessage() {
        assertEquals("test message", MessageUtils.getMessage("test.message"));
    }

    @Test
    void testGetMessage() {
        final Object[] args = {"1st", "2nd"};
        assertEquals("first: 1st, second: 2nd", MessageUtils.getMessage("test.message-with-args", args));
    }
}