package com.issac.ssm.design_pattern.adapter;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-27
 * @desc:
 */
public class DBSocketImpl implements DBSocket {
    @Override
    public void charge() {
        System.out.println("使用双孔插排充电");
    }
}
