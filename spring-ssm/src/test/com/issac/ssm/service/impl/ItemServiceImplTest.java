package com.issac.ssm.service.impl;

import com.issac.ssm.mapper.ItemMapper;
import com.issac.ssm.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-23
 * @desc:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/springmvc.xml")
public class ItemServiceImplTest {

//    @Autowired
//    private ItemService itemService;

    @Autowired
    private ItemMapper itemMapper;

    @Test
    public void test() {
        itemMapper.selectByPrimaryKey(1);
    }
}