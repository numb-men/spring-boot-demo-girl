package com.example.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAge() throws Exception{ //使用MockMvc进行url测试
        mockMvc.perform(MockMvcRequestBuilders.get("/girls/age/10"))
                .andExpect(MockMvcResultMatchers.status().isOk())   //判断返回的HTTP状态码是否OK
                .andExpect(MockMvcResultMatchers.content().string("abc")); //判断返回内容
    }
}