package com.issac.utils;

import com.issac.service.UserService;
import com.issac.service.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-17
 * @desc:
 */
public class MyProxyUtilsTest {

    @Test
    public void testJDKProxy() {
        UserService userService = new UserServiceImpl();
        UserService proxy = MyProxyUtils.getProxy(userService);
        userService.saveUser();
        System.out.println("===========");
        proxy.saveUser();

    }

    @Test
    public void testCglibProxy() {
        UserService userService = new UserServiceImpl();
        UserService proxy = MyProxyUtils.getProxyByCglib(userService);
        userService.saveUser();
        System.out.println("===========");
        proxy.saveUser();
    }
}