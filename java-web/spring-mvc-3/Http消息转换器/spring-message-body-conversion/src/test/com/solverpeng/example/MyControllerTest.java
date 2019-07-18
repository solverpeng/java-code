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
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = MyWebConfig.class)
public class MyControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testController() throws Exception {
        ResultHandler print = MockMvcResultHandlers.print();
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/message")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content("test message");
        this.mockMvc.perform(builder).andDo(print).andExpect(ok);
    }

    @Test
    public void testStringGetController() throws Exception {
        ResultHandler print = MockMvcResultHandlers.print();
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/message/string")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content("test message");
        this.mockMvc.perform(builder).andDo(print).andExpect(ok);
    }

    @Test
    public void testFormPostController () throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post("/message")
                        .contentType("application/x-www-form-urlencoded")
                        //use param instead of content
                        .param("name", "joe");

        this.mockMvc.perform(builder)
                .andExpect(ok);
    }
    @Test
    public void testFormPutController () throws Exception {
        ResultMatcher created = MockMvcResultMatchers.status()
                .isCreated();

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.put("/message")
                        .contentType("application/x-www-form-urlencoded")
                        .content("name=mike");
        this.mockMvc.perform(builder)
                .andExpect(created);
    }

}