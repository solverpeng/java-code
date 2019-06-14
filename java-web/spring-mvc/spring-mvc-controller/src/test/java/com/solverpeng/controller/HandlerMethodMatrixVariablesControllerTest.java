package com.solverpeng.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class HandlerMethodMatrixVariablesControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() {

        this.mockMvc = MockMvcBuilders.standaloneSetup(new HandlerMethodMatrixVariablesController()).setRemoveSemicolonContent(false).build();
    }

    @Test
    public void matrixVariables() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/handlerMethod/matrixVariables/10;q=11;r=22")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void matrixVariables2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/handlerMethod/matrixVariables2/10;q=11/20;q=22")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void matrixVariables3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/handlerMethod/matrixVariables3/42;q=11;r=12/pets/21;q=22;s=23")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}