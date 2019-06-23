package com.issac.util;

import org.springframework.lang.Nullable;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-10
 * @desc:
 */
public interface BeanPostProcessor {
    @Nullable
    default Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }
    @Nullable
    default Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }
}
