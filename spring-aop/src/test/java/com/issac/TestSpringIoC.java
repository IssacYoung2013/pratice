package com.issac;

import com.issac.configuration.SpringConfiguration;
import com.issac.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: ywy
 * @date: 2019-06-14
 * @desc:
 */
public class TestSpringIoC {

    private UserService userService;

    // 执行 @Test 方法之前调用该方法
    @Before
    public void init() {
        // 创建容器
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfiguration.class); // 根据bean类型，从容器中获取实例
        userService = context.getBean(UserService.class);

    }

    @Test
    public void test1() {
        // 创建容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 根据bean类型，从容器中获取实例
        UserService service = context.getBean(UserService.class);
        UserService service2 = (UserService) context.getBean("userService");

        service.saveUser();
        service2.saveUser();
    }

    @Test
    public void test2() {
        // 创建纯注解方式的 spring 容器
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // 从容器中获取bean的实例
        UserService service = context.getBean(UserService.class);
        service.saveUser();

        UserService service2 = (UserService) context.getBean("userService");
        service2.saveUser();
    }

    @Test
    public void test3() {
        userService.saveUser();
    }
}
