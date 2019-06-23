package com.issac.serviceImpl;

import com.issac.service.BaseService;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-12
 * @desc:
 */
public class Dog implements BaseService {
    @Override
    public String doSome() {
        return null;
    }

    @Override
    public void eat() {
        System.out.println("啃骨头");
    }

    @Override
    public void wc() {
        System.out.println("嘘嘘");
    }
}
