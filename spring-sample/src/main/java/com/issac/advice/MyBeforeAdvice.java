package com.issac.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * public class Agent implements InvocationHandler {
 * <p>
 * private BaseService obj;//当前具体被监控对象
 * <p>
 * public Agent(BaseService param) {
 * this.obj = param;
 * }
 * public Object invoke(Object proxy,Method method,Object[] args) {
 * // 织入顺序
 * }
 * <p>
 * // 次要业务
 * public wash() {
 * <p>
 * }
 * }
 *
 * @author: ywy
 * @date: 2019-06-11
 * @desc:
 */
public class MyBeforeAdvice implements MethodBeforeAdvice {
    /**
     * 切面：次要业务
     *
     * @param method
     * @param objects
     * @param o
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("------洗手-----");
    }
}
