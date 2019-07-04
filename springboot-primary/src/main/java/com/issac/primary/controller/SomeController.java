package com.issac.primary.controller;

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
        int i = 3/ 0;
        return "Hello Spring World";
    }
}
