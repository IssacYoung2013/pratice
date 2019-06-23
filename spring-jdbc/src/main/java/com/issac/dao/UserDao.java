package com.issac.dao;

import org.springframework.stereotype.Repository;

/**
 * @author: ywy
 * @date: 2019-06-21
 * @desc:
 */
public interface UserDao {

    void update(Integer id, double money);

    double query(Integer id);
}
