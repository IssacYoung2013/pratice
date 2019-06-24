package com.issac.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-22
 * @desc:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml",
        "classpath:spring/applicationContext-service.xml"})
public class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    public void test() {
        userService.transfer(1,2,100);
    }
}