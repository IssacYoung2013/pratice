package com.issac.service;

import com.issac.dao.UserDao;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: ywy
 * @date: 2019-06-21
 * @desc:
 */
@Service
@Data
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

//    private UserDao userDao;

    @Override
    @Transactional
    public void transfer(Integer from, Integer to, double money) {
        // 先查询 from 账户的钱
        double fromMoney = userDao.query(from);
        // 对 from 账户进行扣钱操作
        userDao.update(from, fromMoney - money);
        // 手动制造异常
        System.out.println(1/0);
        double toMoney = userDao.query(to);
        // 对 to 账户进行加钱操作
        userDao.update(to, toMoney + money);
    }
}
