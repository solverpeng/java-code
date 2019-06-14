package com.solverpeng.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.FormContentFilter;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HelloControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setup() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("utf-8");
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setForceRequestEncoding(true);
        characterEncodingFilter.setForceResponseEncoding(true);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).addFilter(characterEncodingFilter).build();

//        FormContentFilter formContentFilter = new FormContentFilter();
//        this.mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).addFilter(formContentFilter).build();



        this.mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }


    @Test
    public void hello3Test() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.put("/hello3")
                .param("name", "李四")
//                .accept(MediaType.APPLICATION_JSON_UTF8)
                .characterEncoding("utf-8")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void helloCharacterEncodingFilterTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/hello")
                .param("name", "李四")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .characterEncoding("utf-8")
                .contentType("application/x-www-form-urlencoded"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void hello2CharacterEncodingFilterTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/hello2")
                .param("name", "李四")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .characterEncoding("utf-8"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}