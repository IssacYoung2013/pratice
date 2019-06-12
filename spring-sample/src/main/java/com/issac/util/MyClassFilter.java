package com.issac.util;

import com.issac.serviceImpl.Person;
import org.springframework.aop.ClassFilter;

/**
 * @author: ywy
 * @date: 2019-06-12
 * @desc:
 */
public class MyClassFilter implements ClassFilter {

    /**
     * 1. 一个接口下会有多个实现类
     * 2. 判断当前实现类是不是我们织入方式关心的目标类
     * BaseService接口我们现在只想管理Person
     *
     * @param clazz 就是当前被拦截的类：可能是 Person 可能是 Dog
     * @return
     */
    @Override
    public boolean matches(Class<?> clazz) {
        if (clazz == Person.class) {
            // 告诉顾问 当前类需要我们提供织入服务
            return true;
        }
        // Dog 不提供服务
        return false;
    }
}
