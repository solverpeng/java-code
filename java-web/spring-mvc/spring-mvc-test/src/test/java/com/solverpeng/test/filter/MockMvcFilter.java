package com.solverpeng.test.filter;

import com.solverpeng.controller.PersonController;
import org.junit.Before;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

public class MockMvcFilter {
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new PersonController()).addFilters(new CharacterEncodingFilter()).build();
    }

}
