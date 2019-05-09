package com.solverpeng.test.request;

import com.solverpeng.controller.PersonController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

public class MockMvcRequest {
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new PersonController()).build();
    }

    @Test
    public void testRequest() {
        //MockMvcRequestBuilders
        get("");
        post("");
        put("");
        delete("");
        patch("");
        options("");
        head("");
        request(HttpMethod.GET, "");
        multipart("");
        asyncDispatch(null);
    }

    @Test
    public void tetRequest2() {
        //MockHttpServletRequestBuilder
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = get("");

        mockHttpServletRequestBuilder.contextPath("");
        mockHttpServletRequestBuilder.servletPath("");
        mockHttpServletRequestBuilder.pathInfo("");
        mockHttpServletRequestBuilder.secure(true);
        mockHttpServletRequestBuilder.characterEncoding("");
        mockHttpServletRequestBuilder.content("");
        mockHttpServletRequestBuilder.contentType("");
        mockHttpServletRequestBuilder.accept("");
        mockHttpServletRequestBuilder.header("");
        mockHttpServletRequestBuilder.param("");
        mockHttpServletRequestBuilder.cookie();
        mockHttpServletRequestBuilder.locale();
        mockHttpServletRequestBuilder.requestAttr("", "");
        mockHttpServletRequestBuilder.sessionAttr("", "");
        mockHttpServletRequestBuilder.sessionAttrs(null);
        mockHttpServletRequestBuilder.flashAttr("", "");
        mockHttpServletRequestBuilder.flashAttrs(null);
        mockHttpServletRequestBuilder.session(null);
        mockHttpServletRequestBuilder.principal(null);
        mockHttpServletRequestBuilder.with(null);
        mockHttpServletRequestBuilder.buildRequest(null);
        mockHttpServletRequestBuilder.isMergeEnabled();
        mockHttpServletRequestBuilder.merge(null);
        mockHttpServletRequestBuilder.postProcessRequest(null);

    }
}
