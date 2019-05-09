package com.solverpeng.test.response;

import com.solverpeng.controller.PersonController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.xml.xpath.XPathExpressionException;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 期望结果
 */
public class MockMvcResponse {
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new PersonController()).build();
    }

    @Test
    public void testResponse() throws XPathExpressionException {
        // 期望结果 andExpect ResultMatcher MockMvcResultMatchers
        status();
        request();
        handler();
        model();
        view();
        flash();
        forwardedUrl("");
        forwardedUrlTemplate("");
        forwardedUrlPattern("");
        redirectedUrl("");
        redirectedUrlTemplate("");
        redirectedUrlPattern("");
        header();
        content();
        jsonPath("");
        xpath("");
        cookie();

    }
}
