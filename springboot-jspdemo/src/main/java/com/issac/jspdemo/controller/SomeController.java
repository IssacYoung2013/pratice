package com.issac.jspdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-30
 * @desc:
 */
@Controller
public class SomeController {

    @GetMapping("/some")
    public String someHandle() {
        return "page/welcome";
    }
}
