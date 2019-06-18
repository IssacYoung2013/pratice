package com.issac.advice;

import com.issac.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-18
 * @desc:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MyAdviceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testBefore() {
        userService.updateUser();
    }
}