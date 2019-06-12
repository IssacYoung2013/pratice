package com.issac.util;

import org.springframework.aop.MethodMatcher;

import java.lang.reflect.Method;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-12
 * @desc:
 */
public class MyMethodMatcher implements MethodMatcher {

    /**
     * 被监控接口（BaseService），没有重载方法
     * 每一个方法名称都是唯一
     * 此时可以采用static检测方式，只根据方法名称判断
     *
     * 业务：只想为Person类中的eat方法提供织入服务
     *
     * @param method 接口中的某一个方法
     * @param targetClass 接口一个实现类
     * @return
     */
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        String methodName = method.getName();
        if("eat".equals(methodName)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isRuntime() {
        return false;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        return false;
    }
}
