package com.issac.ssm.controller;

import com.issac.ssm.exception.CustomException;
import com.issac.ssm.po.Item;
import com.issac.ssm.service.ItemService;
import com.issac.ssm.vo.ItemQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
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
@RequestMapping(value = "/item",
        produces = "application/json;charset=utf8")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // RequestMapping 此时填写的是url
//    @RequestMapping("/list")
//    public ModelAndView queryItem() {
//        List<Item> itemList = itemService.queryItemList();
//
//        ModelAndView modelAndView = new ModelAndView();
//
//        modelAndView.addObject("itemList", itemList);
//        // 设置view
////        modelAndView.setViewName("/WEB-INF/jsp/item/item-list.jsp");
//        // 逻辑路径
//        modelAndView.setViewName("item/item-list");
//        return modelAndView;
//    }

    @RequestMapping("/list")
    public String queryItem(HttpServletRequest request, Model model) {
        List<Item> itemList = itemService.queryItemList();

        // 使用 request api 完成
//        request.setAttribute("itemList",itemList);

        // 使用 Model 接口的 api
        model.addAttribute("itemList", itemList);

//        return "item/item-list";
        request.setAttribute("id", 1);
//        return "redirect:testRedirect";
        return "forward:testForward";
    }

    //请求重定向测试
    @RequestMapping("testRedirect")
    public String testRediect(HttpServletRequest request) {
        String id = (String) request.getAttribute("id");
        System.out.println("request域的数据" + id);
        return "";
    }

    //请求转发测试
    @RequestMapping("testForward")
    public String testForward(HttpServletRequest request) {
        String id = request.getAttribute("id").toString();
        System.out.println("request域的数据" + id);
        //ModelAndView实质中就是进行视图转发
        return "";
    }

    @RequestMapping("queryItemById")
    public @ResponseBody Item queryItemById() {
        Item item = itemService.queryItemById(1);
        return item;
    }

    // 设置响应体编码格式
    @RequestMapping(value = "testReturnString",
            method = RequestMethod.GET)
    @ResponseBody
    public String testReturnString() {
        return "返回字符串";
    }

    // 设置响应体编码格式
    @RequestMapping(value = "testReturnString",
            produces = "application/json;charset=utf8",
            method = RequestMethod.POST)
    @ResponseBody
    public String testReturnString2() {
        return "返回字符串222";
    }

    // @RequestParam 相当于 Request.getParameter(请求参数key)
    @RequestMapping("findItem")
    @ResponseBody
    public String findItem(@RequestParam(value = "itemid",
            required = false,defaultValue = "3") Integer id) {
        System.out.println(id);
        return "接收到的请求参数是 " + id;
    }

    @RequestMapping("updateItem")
    @ResponseBody
    public Item updateItem(Integer id, String name, BigDecimal price,Item item) {

        return item;
    }

    @RequestMapping("queryItem")
    @ResponseBody
    public Item queryItem(ItemQueryVO vo){

        return vo.getItem();
    }

    @RequestMapping("listAll")
    public String queryItemList(ItemQueryVO vo,Model model) throws CustomException {
        List<Item> itemList = itemService.queryItemList();

        if(itemList.size() < 10) {
            throw new CustomException("自定义异常");
        }
        model.addAttribute("itemList", itemList);
        return "item/item-list";
    }

    @RequestMapping("deleteItem")
    @ResponseBody
    public String[] deleteItem(String[] id) {
        return id;
    }

    @RequestMapping("batchUpdateItem")
    @ResponseBody
    public ItemQueryVO batchUpdateItem(ItemQueryVO vo){

        return vo;
    }

    @RequestMapping("saveItem")
    @ResponseBody
    public Date saveItem(Date date) {

        return date;
    }
}
