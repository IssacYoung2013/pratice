package com.issac.mybatisdemo.service.impl;

import com.issac.mybatisdemo.dao.EmployeeDao;
import com.issac.mybatisdemo.po.Employee;
import com.issac.mybatisdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: ywy
 * @date: 2019-07-03
 * @desc:
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao dao;

//    @Transactional
    @Override
    public void addEmployee(Employee employee) {
        dao.insertEmployee(employee);
//        int i = 3 / 0;
//        dao.insertEmployee(employee);
    }
}
