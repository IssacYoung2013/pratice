package com.issac.ssm.design_pattern.decorate;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-27
 * @desc:
 */
public class IPhoneImpl implements Phone {
    @Override
    public void call() {
      System.out.println("使用iphone6打电话，性能刚刚的");
    }
}
