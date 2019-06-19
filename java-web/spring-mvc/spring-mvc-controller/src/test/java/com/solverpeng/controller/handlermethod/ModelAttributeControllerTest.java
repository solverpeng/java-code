package com.solverpeng.controller.handlermethod;

import com.solverpeng.controller.handlermethod.ModelAttributeController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ModelAttributeControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new ModelAttributeController()).build();
    }

    @Test
    public void defaultConstructor() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/modelAttribute/defaultConstructor")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void modelAttributeMethod() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/modelAttribute/modelAttributeMethod")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void bindWithModelMethodFalse() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/modelAttribute/modelAttributeBindingFalse")
                .param("name", "tom")
                .param("age", "22")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void servletRequestParam() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/modelAttribute/bindServletRequestParam")
                .param("addressName", "shanghai")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}