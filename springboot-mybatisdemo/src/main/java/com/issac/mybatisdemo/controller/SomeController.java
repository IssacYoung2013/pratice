package com.issac.mybatisdemo.controller;

import com.issac.mybatisdemo.po.Employee;
import com.issac.mybatisdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-30
 * @desc:
 */
@Controller
@RequestMapping("/test")
public class SomeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/register")
    public String someHandle(Employee employee) {
        service.addEmployee(employee);
        return "page/welcome";
    }


}
