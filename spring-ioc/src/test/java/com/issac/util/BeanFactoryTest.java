package com.issac.util;

import com.issac.beans.Teacher;
import com.issac.service.BaseService;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author: ywy
 * @date: 2019-06-08
 * @desc:
 */
public class BeanFactoryTest {

    @Test
    public void test() throws Exception {

        // 1. 声明注册bean
        BeanDefined beanDefined = new BeanDefined();
        beanDefined.setBeanId("teacher");
        beanDefined.setClassPath("com.issac.beans.Teacher");
        /**
         * <property></property>
         */
        Map propertyMap = beanDefined.getPropertyMap();
        propertyMap.put("teacherName","Mr Young");
        propertyMap.put("friendArray","mike,tom,allen");
        propertyMap.put("school","江西师范大学，上饶市二中");
//        beanDefined.setScope("prototype");
//        beanDefined.setFactoryBean("factory1");
//        beanDefined.setFactoryMethod("createTeacher");
//        beanDefined.setBeanId("isomeService");
//        beanDefined.setClassPath("com.issac.serviceImpl.ISomeService");

        BeanDefined beanDefined2 = new BeanDefined();
//        beanDefined2.setBeanId("factory1");
//        beanDefined2.setClassPath("com.issac.util.TeacherFactory");
        beanDefined2.setClassPath("com.issac.util.MyBeanPostProcessor");


        List configuration = new ArrayList();
        configuration.add(beanDefined); // spring 核心配置
        configuration.add(beanDefined2);

        // 2. 声明一个Spring提供的BeanFactory工厂
        BeanFactory factory = new BeanFactory(configuration);
        factory.setBeanDefinedList(configuration);

        // 3. 开发人员向BeanFactory索要实例对象
        Teacher t = (Teacher) factory.getBean("teacher");
        System.out.println("t1="+t);
        Teacher t2 = (Teacher) factory.getBean("teacher");
        System.out.println("t2="+t2);
//        BaseService t = (BaseService)factory.getBean("isomeService");
//        System.out.println("t="+t);
//        System.out.println(t.doSome());
        
    }
}