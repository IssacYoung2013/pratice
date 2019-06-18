package com.issac.configuration;

import com.issac.service.UserDao;
import com.issac.service.UserService;
import com.issac.service.UserServiceImpl;
import org.springframework.context.annotation.*;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-16
 * @desc:
 */
// @Configuration 相当于一个 spring的 xml 配置文件中的 beans 根标签
// <beans></beans>
// 配置类
@Configuration
@ComponentScan(basePackages = "com.issac.service")
@Import(DaoConfiguration.class)
// 相当于 context:component-scane标签
public class SpringConfiguration {
    public SpringConfiguration() {
        System.out.println("容器初始化");
    }

//    @Bean
//    public UserDao userDao() {
//        return new UserDao();
//    }
//
    // 纯注解的方式之IoC配置，通过 @Bean 注解，通过方式一注册
    // Bean注解，可以指定bean的id，如果不指定，默认bean的id就是@Bean注解对应的方法名称
    @Bean(value = "userService")
    @Scope("prototype")
    public UserService userService() {
        return new UserServiceImpl();
    }
}
