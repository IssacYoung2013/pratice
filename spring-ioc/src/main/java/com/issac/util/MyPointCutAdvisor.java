package com.issac.util;

import lombok.Setter;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-12
 * @desc:
 */
@Setter
public class MyPointCutAdvisor implements PointcutAdvisor {

    // 采用依赖注入
    // 次要业务以及次要业务与主要业务的执行顺序
    private Advice advice;

    //当前拦截对象和对象调用的业务方法 person对象eat方法
    private Pointcut pointcut;

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }
}
