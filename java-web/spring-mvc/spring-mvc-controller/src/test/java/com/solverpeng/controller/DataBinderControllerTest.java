package com.solverpeng.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

public class DataBinderControllerTest {

    private MockMvc mockMvc;

    @Before
    public void init() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new DataBinderController()).build();
    }

    @Test
    public void helloDataBinder() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/dataBinder/helloDataBinder")
                .param("name", "jerry")
                .param("age", "33")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void dataBinderWithMethodArgs() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/dataBinder/dataBinderWithMethodArgs")
                .param("name", "tom")
                .param("age", "22")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void bindRequestParamToModelAttribute() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/dataBinder/bindRequestParamToModelAttribute")
                .param("name", "tom")
                .param("password", "123456")
                .param("id", "2")
                .param("email", "tom@123.com")
                .param("dateOfBirth", "2011-10-10")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void dataBindWithFormatter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/dataBinder/dataBindWithFormatter")
                .param("tradeId", "1")
                .param("amount", "75555.56789456456856865")
                .param("tradeDate", "2008-05-28")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void dataBindWithAnnotationFormatter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/dataBinder/dataBindWithAnnotationFormatter")
                .param("orderId", "1")
                .param("amount", "75555.56789456456856865")
                .param("tradeDate", "2008-05-28")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}