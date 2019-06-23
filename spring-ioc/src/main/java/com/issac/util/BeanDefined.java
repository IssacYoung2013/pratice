package com.issac.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * bean 定义对象
 *
 * @author: ywy
 * @date: 2019-06-08
 * @desc:
 */
@Data
public class BeanDefined {
    /**
     * <bean id,class,scope,factory-bean,factory-method></bean>
     *
     *
     *
     */
    private String beanId;
    private String classPath;
    private String scope = "singleton";
    private String factoryBean = null;
    private String factoryMethod = null;
    private Map<String,String> propertyMap = new HashMap<>();
}
