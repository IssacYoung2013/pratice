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

    @GetMapping("/first/some")
    public String firstHandle() {
        return "first";
    }

    @GetMapping("/first/aaa")
    public String firstAaaHandle() {
        return "first aaa";
    }


    @GetMapping("/first/bbb")
    public String firstBbbHandle() {
        return "first bbb";
    }


    @GetMapping("/second/other")
    public String secondHandle() {
        return "second";
    }

    @GetMapping("/third/xxx")
    public String thirdHandle() {
        return "third";
    }
}
