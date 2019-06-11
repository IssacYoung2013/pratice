package com.issac.beans;

import lombok.Getter;
import lombok.Setter;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-08
 * @desc:
 */
@Getter
@Setter
public class Student {
    private String sname;
    private int age;
    private Teacher teacher;
}
