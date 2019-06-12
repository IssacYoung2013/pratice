package com.issac.serviceImpl;

import com.issac.service.BaseService;

/**
 * @author: ywy
 * @date: 2019-06-09
 * @desc:
 */
public class Person implements BaseService {
    @Override
    public String doSome() {
        return "Hello Issac"; // 增强效果，doSome方法返回值都是大写
    }

    @Override
    public void eat() { // 切入点 PointCut 主要业务方
        System.out.println("吃水果");
    }

    @Override
    public void wc() {
        System.out.println("上厕所");
    }
}
