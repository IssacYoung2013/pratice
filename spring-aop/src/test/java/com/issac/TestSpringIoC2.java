package com.issac;

import com.issac.configuration.SpringConfiguration;
import com.issac.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author: ywy
 * @date: 2019-06-14
 * @desc:
 */
// @RunWith JUnit 自身的注解，它的作用是可以指定一个新的运行器，进行单元测试
// SpringJUnit4ClassRunner: Spring 提供的单元测试运行器
@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration：SpringJUnit4ClassRunner 需要的上下文配置信息，方便创建Spring 容器
// classes：纯注解的方式时，读取配置类
// locations：XML方式时，读取配置文件
@ContextConfiguration(classes = SpringConfiguration.class)
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestSpringIoC2 {

    @Resource
    private UserService userService;

    @Test
    public void test1() {
        userService.saveUser();
    }
}
