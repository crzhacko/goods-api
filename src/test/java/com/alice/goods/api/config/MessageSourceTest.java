package com.alice.goods.api.config;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    private MessageSource messageSource;

    @Test
    void message() {
        assertEquals("test message", messageSource.getMessage("test.message", null, Locale.getDefault()));

        final Object[] args = {"1st", "2nd"};
        assertEquals("first: 1st, second: 2nd", messageSource.getMessage("test.message-with-args", args, Locale.getDefault()));
    }

}
