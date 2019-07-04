package com.issac.ssm.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-30
 * @desc: @WebAppConfiguration 在单元测试的时候，不用启动Servlet容器，就可以获取web应用的上下文
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/*.xml")
@WebAppConfiguration
public class TestMockMvc {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setupContext() {
        // 初始化一个mockmvc对象
        // 建议使用web上下文设置
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .build();

    }

    @Test
    public void test() throws Exception {

        // 通过perform去执行http请求
        // andExpect 通过该方法判断请求是否成功
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/item/showEdit")
//                .param("id","1")
//                )
//        .andExpect(MockMvcResultMatchers.view().name("item/item-edit"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//        .andDo(MockMvcResultHandlers.print())
//        .andReturn();

       MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/item/queryItem")
                .param("id","1")
               .accept(MediaType.APPLICATION_JSON)
        )
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        System.out.println("============");

        System.out.println(result.getHandler());

    }
}