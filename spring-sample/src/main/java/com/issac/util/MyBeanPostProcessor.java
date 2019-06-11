package com.issac.util;

//import com.issac.serviceImpl.ISomeService;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanPostProcessor;

import com.issac.serviceImpl.ISomeService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: ywy
 * @date: 2019-06-09
 * @desc:
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        System.out.println("bean对象初始化之前。。。。");
        return bean;
        // return bean对象监控代理对象
    }

    @Override
    public Object postProcessAfterInitialization(final Object beanInstance, String beanName) throws Exception {
        // 为当前bean对象注册代理监控对象，负责增强bean对象方法能力
        Class beanClass = beanInstance.getClass();
        if (beanClass == ISomeService.class) {
            Object proxy = Proxy.newProxyInstance(beanInstance.getClass().getClassLoader(),
                    beanInstance.getClass().getInterfaces(),
                    new InvocationHandler() {
                        /**
                         *
                         * @param proxy： 代理监控对象
                         * @param method : doSome
                         * @param args : doSome执行接受的实参
                         * @return
                         * @throws Throwable
                         */
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            System.out.println("ISomeService doSome 被拦截");
                            String result = (String) method.invoke(beanInstance, args);
                            return result.toUpperCase();
                        }
                    });
            return proxy;
        }
        return beanInstance;
    }
}
