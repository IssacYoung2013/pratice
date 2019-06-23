package com.issac.beans;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-08
 * @desc:
 */
@Getter
@Setter
public class Teacher {

    /**
     * DI: Spring 框架通过反射机制，调用属性对应的set方法进行赋值
     */

    private String tname;

    private String teacherName;
    private String friendArray[];
    private List<String> school;

    public void setFriendArray(Object friendArray) {
        this.friendArray = (String[])friendArray;
    }
}
