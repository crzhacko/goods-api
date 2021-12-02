package com.alice.goods.api.util;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

/**
 * spring validator의 BindingResult의 에러메세지는 매우 많은 정보를 포함하고 있다.
 * 각 유효성 어노테이션의 message 속성에 기재된 메시지만 추출하여 보여주기 위해 작성된 유틸리티
 */
public class ValidatorUtils {

    /**
     * 어노테이션의 message속성에 기재된 내용만 세미콜론을 구분자로 반환
     * @param errors
     * @return
     */
    public static String getAllErrorMessages(Errors errors) {
        return errors.getAllErrors().stream()
                .reduce("", (message, error) -> {
                    String delimeter = StringUtils.hasText(message) ? "; " : "";
                    return message + delimeter + error.getDefaultMessage();
                }, (message, error) -> message);
    }

}
