package com.issac.ssm.controller;

import com.issac.ssm.exception.CustomException;
import com.issac.ssm.po.Item;
import com.issac.ssm.service.ItemService;
import com.issac.ssm.vo.ItemQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
@RequestMapping(value = "item"
        ,
        produces = "application/json;charset=utf8"
)
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
    public @ResponseBody
    Item queryItemById() {
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
            required = false, defaultValue = "3") Integer id) {
        System.out.println(id);
        return "接收到的请求参数是 " + id;
    }

    @RequestMapping(value = "updateItem",method = RequestMethod.POST)
    @ResponseBody
    public Item updateItem(Integer id, String name, BigDecimal price, Item item,
                           MultipartFile pictureFile) throws IOException {

        System.out.println(pictureFile);
        if (pictureFile != null) {

            // 获取上传文件名称
            String orginalFilename = pictureFile.getOriginalFilename();
            if (!StringUtils.isEmpty(orginalFilename)) {

                // 获取扩展名
                String extName = orginalFilename.substring(orginalFilename.lastIndexOf("."));
                // 重新生成一个文件名称
                String newFileName = UUID.randomUUID().toString() + extName;
                // 指定存储文件的目录
                String baseDir = "/Users/Issac/workspaces/github/upload/";
                File dirFile = new File(baseDir);
                if (!dirFile.exists()) {
                    dirFile.mkdir();
                }
                // 将上传的文件复制到新的文件中
                pictureFile.transferTo(new File(baseDir + newFileName));
                item.setPic(newFileName);
            }
        }

        // 商品修改
        itemService.updateItem(item);

        return item;
    }

    @RequestMapping("queryItem")
    @ResponseBody
    public Item queryItem(ItemQueryVO vo) {

        return vo.getItem();
    }

    @RequestMapping("listAll")
    public String queryItemList(ItemQueryVO vo, Model model) throws CustomException {
        List<Item> itemList = itemService.queryItemList();

//        if (itemList.size() < 10) {
//            throw new CustomException("自定义异常");
//        }
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
    public ItemQueryVO batchUpdateItem(ItemQueryVO vo) {

        return vo;
    }

    @RequestMapping("saveItem")
    @ResponseBody
    public Date saveItem(Date date) {

        return date;
    }

    @RequestMapping("showEdit")
    public String showEdit(Integer id, Model model) {

        Item item = itemService.queryItemById(id);
        model.addAttribute("item", item);
        return "item/item-edit";
    }

}
