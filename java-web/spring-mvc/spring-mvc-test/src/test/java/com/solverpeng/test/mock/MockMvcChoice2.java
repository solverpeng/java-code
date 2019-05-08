package com.solverpeng.test.mock;

import com.solverpeng.controller.PersonController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerMapping;

import java.util.List;

public class MockMvcChoice2 {
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new PersonController()).build();
    }

    @Test
    public void test() {
        DispatcherServlet dispatcherServlet = mockMvc.getDispatcherServlet();
        List<HandlerMapping> handlerMappings = dispatcherServlet.getHandlerMappings();
        assert handlerMappings != null;
        for (HandlerMapping handlerMapping : handlerMappings) {
            System.out.println(handlerMapping);
        }
    }

    @Test
    public void testGetPerson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getPerson")).andExpect(MockMvcResultMatchers.status().isOk());
    }

}
