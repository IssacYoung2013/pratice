package com.issac.webflux.router.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 *
 * @author: ywy
 * @date: 2019-07-27
 * @desc:
 */
@Getter
@Setter
@NoArgsConstructor
public class StudentException extends RuntimeException {
    private String errField;
    private String errValue;

    public StudentException(String message, String errField, String errValue) {
        super(message);
        this.errField = errField;
        this.errValue = errValue;
    }
}
