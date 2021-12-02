package com.alice.goods.api.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * messageSource를 좀더 편리하게 사용하기 위한 유틸리티
 * 스프링 빈이 아닌 객체도 사용 가능
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Component
public class MessageUtils implements ApplicationContextAware {

    private static MessageSource messageSource;

    public static String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, Locale.getDefault());
    }

    public static String getMessage(String code) {
        return messageSource.getMessage(code, null, Locale.getDefault());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        MessageUtils.messageSource = applicationContext.getBean(MessageSource.class);
    }
}
