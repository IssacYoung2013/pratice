package com.issac.thymeleaf.controller;

import com.issac.thymeleaf.vo.StudentVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: ywy
 * @date: 2019-07-07
 * @desc:
 */
@Controller
public class ThymeleafController {

    @RequestMapping("/some")
    public String indexHandle(Model model) {
        model.addAttribute("hello","Hello Thymeleaf World!");
        model.addAttribute("student",new StudentVO("张三",23));
        return "index";
    }
}
