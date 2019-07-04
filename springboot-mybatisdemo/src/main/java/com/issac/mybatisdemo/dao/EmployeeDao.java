package com.issac.mybatisdemo.dao;

import com.issac.mybatisdemo.po.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 *
 * @author: ywy
 * @date: 2019-07-03
 * @desc:
 */
@Mapper
public interface EmployeeDao {

    void insertEmployee(Employee employee);
}
