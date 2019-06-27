package com.issac.ssm.exception;

import lombok.Data;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-27
 * @desc:
 */
@Data
public class CustomException extends Exception {

    private String msg;

    public CustomException(String message) {
        super();
        this.msg = message;
    }
}
