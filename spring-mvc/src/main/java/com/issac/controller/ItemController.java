package com.issac.controller;

import com.issac.po.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理器的开发方式有多种，比如实现 HttpRequestHandler 接口、Controller 接口的方式，还有注解的方式
 * 企业中一般使用注解方式
 * 注解的方式，主要有两个注意事项：
 * 类上加上@Controller注解（必须是Controller）
 * 类上或者方法上面要加上 @RequestMapping
 *
 * @author: ywy
 * @date: 2019-06-23
 * @desc:
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    // RequestMapping 此时填写的是url
    // ModelAndView: model表示数据模型，view就是最终显示的视图
    @RequestMapping("/list")
    public ModelAndView queryItem() {
        List<Item> itemList = new ArrayList<>();

        //商品列表
        Item item_1 = new Item();
        item_1.setName("联想笔记本_3");
        item_1.setPrice(6000f);
        item_1.setDetail("ThinkPad T430 联想笔记本电脑！");

        Item item_2 = new Item();
        item_2.setName("苹果手机");
        item_2.setPrice(5000f);
        item_2.setDetail("iphone6苹果手机！");

        itemList.add(item_1);
        itemList.add(item_2);

        ModelAndView modelAndView = new ModelAndView();

        // 设置数据模型，相当于request的setAttribute方法，实质上，底层确实也是转成了request
        // 先将kv数据放入map中，最终根据视图对象不同，再进行后续处理
        modelAndView.addObject("itemList", itemList);

        // 设置view
//        modelAndView.setViewName("/WEB-INF/jsp/item/item-list.jsp");
        // 逻辑路径
        modelAndView.setViewName("item/item-list");

        return modelAndView;
    }
}
