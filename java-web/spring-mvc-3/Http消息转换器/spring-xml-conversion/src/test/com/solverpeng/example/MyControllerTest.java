package com.solverpeng.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = MyWebConfig.class)
public class MyControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testCheck() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/message/check");

        this.mockMvc.perform(requestBuilder).andExpect(ok).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testController() throws Exception {
        ResultMatcher created = MockMvcResultMatchers.status().isCreated();

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/message/register")
                .contentType(MediaType.APPLICATION_XML)
                .content(createUserInXML("tom", "tom@123.com", "abc"));

        this.mockMvc.perform(requestBuilder).andExpect(created).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testReceiveUserList() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();

        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/message/userList")
                        .accept(MediaType.APPLICATION_XML);

        this.mockMvc.perform(requestBuilder).andExpect(ok).andDo(MockMvcResultHandlers.print());
    }


    private String createUserInXML(String name, String email, String password) {
        return "<user>" +
                "<name>" + name + "</name>" +
                "<emailAddress>" + email + "</emailAddress>" +
                "<password>" + email + "</password>" +
                "</user>";
    }



}