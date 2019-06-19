package com.solverpeng.controller.handlermethod;

import com.solverpeng.controller.handlermethod.SessionAttributesController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


public class SessionAttributesControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new SessionAttributesController()).build();
    }

    @Test
    public void addToSessionAttribute() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/sessionAttributes/add")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
        Thread.sleep(50000);
    }

    @Test
    public void addToSessionAttribute2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/sessionAttributes/add2")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void removeSessionAttributes() {
    }

    @Test
    public void getSessionAttributes() {
    }
}