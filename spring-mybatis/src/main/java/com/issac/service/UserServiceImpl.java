package com.issac.service;

import com.issac.mapper.UserMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author: ywy
 * @date: 2019-06-21
 * @desc:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional
    public void transfer(Integer from, Integer to, double money) {
        double fromMoney = userMapper.queryMoney(from);
        userMapper.update(from, fromMoney - money);
//        System.out.println(1/0);
        double toMoney = userMapper.queryMoney(to);
        userMapper.update(to, toMoney + money);
    }
}
