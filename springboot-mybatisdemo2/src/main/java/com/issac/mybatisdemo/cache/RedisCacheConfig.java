package com.issac.mybatisdemo.cache;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ywy
 * @date: 2019-07-07
 * @desc:
 */
@Configuration
public class RedisCacheConfig extends CachingConfigurerSupport {

    // 自动生成的key结构：类名_方法名_参数名
    // 本例：EmployeeImpl_findEmployeeById_3
    @Override
    public KeyGenerator keyGenerator() {


        return (target, method, params) -> {
            // 获取注解所在方法类名
            String className = target.getClass().getName();
            String methodName = method.getName();
            return className + "_" + methodName + "_" + params[0].toString();
        };
    }
}
