package com.issac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * @author: ywy
 * @date: 2019-06-14
 * @desc:
 */
@Service("userService")
@PropertySource("classpath:data.properties")
// 相当于 context:property-placeholder
public class UserServiceImpl implements UserService {

    @Autowired(required = true)
    @Qualifier("userDao")
//    @Resource
    private UserDao dao;

    // 简单类型的注入（配合properties文件使用）
//    @Value("${name}")
    @Value(("${id}"))
    private int id;

    // 有参构造
    public UserServiceImpl(int id) {
        System.out.println(id);
    }

    public UserServiceImpl() {
    }

    @Override
    public void saveUser() {
        System.out.println("添加用户 :"+id);
        // 抛出异常的代码
        System.out.println(1/0);
    }

    @Override
    public void updateUser() {
        System.out.println("修改用户");
    }
}
