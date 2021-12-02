package com.alice.goods.api.exception;

import com.alice.goods.api.dto.AliceResponse;
import com.alice.goods.api.util.ValidatorUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ControllerAdvice {

    /**
     * 컨트롤러의 입력 파라미터 유효성 검사에 의한 예외 응답 처리
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AliceResponse> handler(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(AliceResponse.of(AliceError.InvalidArguments.getValue(), ValidatorUtils.getAllErrorMessages(e.getBindingResult())));
    }

    /**
     * application 내 정의된 커스텀 예외(AliceApiException)에 대한 응답 처리
     * @param e
     * @return
     */
    @ExceptionHandler(AliceApiException.class)
    public ResponseEntity<AliceResponse> handler(AliceApiException e) {
        return ResponseEntity
                .status(e.getStatus())
                .body(AliceResponse.of(e.getErrorCode(), e.getMessage()));
    }
}
