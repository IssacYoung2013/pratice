package com.issac.webflux.util;

import com.issac.webflux.exception.StudentException;

import java.util.stream.Stream;

/**
 *
 *
 * @author: ywy
 * @date: 2019-07-27
 * @desc:
 */
public class NameValidateUtil {

    /**
     * 无效姓名列表
     */
    private static final String[] INVALID_NAMES = {"admin","administrator","xxx","ooo"};

    public static void validateName(String name) {
        Stream.of(INVALID_NAMES)
                .filter(invalidName -> name.equalsIgnoreCase(invalidName))
                .findAny()
                .ifPresent(invalidName->{
                    throw new StudentException("name",invalidName,"使用了非法姓名");
                });
    }
}
