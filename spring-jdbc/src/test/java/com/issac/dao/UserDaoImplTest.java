package com.issac.dao;

import com.issac.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-21
 * @desc:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-transfer.xml")
//@ContextConfiguration(locations = "classpath:spring-transfer-annotation.xml")

public class UserDaoImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        userService.transfer(1,2,100);
    }
}