package com.issac.mybatisdemo.controller;

import com.issac.mybatisdemo.po.Employee;
import com.issac.mybatisdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/find")
    @ResponseBody
    public Employee findHandle(int id) {
        return service.findEmployeeById(id);
    }

    @RequestMapping("/count")
    @ResponseBody
    public int countHandle() {
        return service.findEmployeeCount();
    }
}
