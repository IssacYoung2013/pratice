package com.issac.mybatisdemo.po;

import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 * @author: ywy
 * @date: 2019-07-03
 * @desc:
 */
@Data
public class Employee implements Serializable{
    private Integer id;
    private String name;
    private int age;
}
