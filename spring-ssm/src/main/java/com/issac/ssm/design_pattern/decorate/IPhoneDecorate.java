package com.issac.ssm.design_pattern.decorate;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-27
 * @desc: 装饰类
 */
public class IPhoneDecorate implements Phone{

    // 被装饰的目标类
    private IPhoneImpl iPhone;

    // 通过构造函数传入目标类
    public IPhoneDecorate(IPhoneImpl iPhone) {
        this.iPhone = iPhone;
    }

    @Override
    public void call() {
        System.out.println("人猿泰山music。。。");
        iPhone.call();
    }
}
