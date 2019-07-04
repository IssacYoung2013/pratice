package com.issac.webdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-30
 * @desc:
 */
@RestController
public class SomeController {

    @GetMapping("/some")
    public String someHandle() {
        return "Hello Spring Boot World";
    }
}
