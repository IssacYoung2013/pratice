package com.issac.serviceImpl;

import com.issac.service.BaseService;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-09
 * @desc:
 */
public class ISomeService implements BaseService {
    @Override
    public String doSome() {
        return "Hello Issac"; // 增强效果，doSome方法返回值都是大写
    }
}
