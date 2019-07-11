package com.issac.ssm.controller;

import com.issac.ssm.po.Item;
import com.issac.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-25
 * @desc:
 */
// @RestController 相当于 @Controller 和 @ResponseBody 的组合
@RestController
public class RestItemController {

    @Autowired
    private ItemService service;

    @RequestMapping("queryItemByIdWithRest")
    public Item queryItemById() {
        return service.queryItemById(1);
    }

    @RequestMapping("testReturnStringWithRest")
    public String testReturnString() {
        return "ok";
    }
}
