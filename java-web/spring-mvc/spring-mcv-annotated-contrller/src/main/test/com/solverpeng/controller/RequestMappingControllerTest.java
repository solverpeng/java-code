package com.solverpeng.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RequestMappingControllerTest {


    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new RequestMappingController()).build();
    }


    /**
     * 混用Ant和正则匹配
     */
    @Test
    public void testRequestMappingAntAndRegex() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/persons/ant5/aaa/tom"))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
    }

    /**
     * 测试请求映射Ant匹配
     */
    @Test
    public void testRequestMappingAnt() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/persons/ant1a"))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/persons/ant2aaaaa"))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/persons/ant3/aaaa"))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
    }

    /**
     * 测试请求映射正则匹配
     */
    @Test
    public void testRequestMappingRegex() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/persons/tom-22"))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
    }

    // 测试路径变量
    @Test
    public void getPerson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/persons/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    // 测试映射方法
    @Test
    public void addPerson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/persons")
                .accept(MediaType.parseMediaType("application/json;charset=utf-8"))
                .param("person", "name=tom"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }


}