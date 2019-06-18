package com.solverpeng.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.http.Cookie;

import static org.junit.Assert.*;

public class HandlerMethodCookieValueControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new HandlerMethodCookieValueController()).build();
    }

    @Test
    public void handler() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/cookieValue/jsessionid")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .cookie(new Cookie("JSESSIONID", "415A4AC178C59DACE0B2C9CA727CDD84")))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}