package com.issac.webflux.advice;

import com.issac.webflux.exception.StudentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;

/**
 * @author: ywy
 * @date: 2019-07-27
 * @desc: @ControllerAdvice 表示当前类为通知（切面），其连接点为处理器方法
 * 验证失败则返回失败信息，即400状态
 */
@ControllerAdvice
public class ParameterValidateAdvice {

    @ExceptionHandler
    public ResponseEntity<String> validateHandle(StudentException ex) {
        String msg = ex.getMessage() + "【" + ex.getErrValue() + ex.getErrField() + "】";
        return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> validateHandle(WebExchangeBindException ex) {
        return new ResponseEntity<>(exToStr(ex), HttpStatus.BAD_REQUEST);
    }

    /**
     * 将所有的异常信息转换为一个String
     * 对流的执行效率要高
     *
     * @param ex
     * @return
     */
    private String exToStr(WebExchangeBindException ex) {

        return ex.getFieldErrors()
                .stream()
                .map(e -> e.getField() + ":" + e.getDefaultMessage())
                .reduce("", (s1, s2) -> s1 + "\n" + s2);
    }

}
