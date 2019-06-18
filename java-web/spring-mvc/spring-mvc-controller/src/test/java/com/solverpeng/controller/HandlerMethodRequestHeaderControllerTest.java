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

public class HandlerMethodRequestHeaderControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new HandlerMethodRequestHeaderController()).build();
    }

    @Test
    public void handle() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestHeader/headers")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .header("Keep-Alive", 300)
                .header("Accept-Encoding", "utf-8")
                .header("host", "localhost"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void handle2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestHeader/map")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .header("Keep-Alive", 300)
                .header("Accept-Encoding", "utf-8")
                .header("host", "localhost"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void handle3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestHeader/map2")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .header("Keep-Alive", 300)
                .header("Accept-Encoding", "utf-8")
                .header("host", "localhost"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void handle4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestHeader/httpHeaders")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .header("Keep-Alive", 300)
                .header("Accept-Encoding", "utf-8")
                .header("host", "localhost"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void handle5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestHeader/multiHeader")
                .accept("text/html,application/xhtml+xml,application/xml"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}