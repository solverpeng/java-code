package com.solverpeng.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = MyWebConfig.class)
public class UserRegistrationControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        DefaultMockMvcBuilder defaultMockMvcBuilder = MockMvcBuilders.webAppContextSetup(context);
        this.mockMvc = defaultMockMvcBuilder.build();
    }

    @Test
    public void testUserController() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/register");
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        this.mockMvc.perform(requestBuilder).andDo(MockMvcResultHandlers.print()).andExpect(ok);

        MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post("/register")
                .param("name", "tom")
                .param("email", "tom@abc.com")
                .param("password", "abc");
        this.mockMvc.perform(postBuilder).andDo(MockMvcResultHandlers.print()).andExpect(ok);
    }
}