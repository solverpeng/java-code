package com.solverpeng.controller.handlermethod;

import com.solverpeng.controller.handlermethod.RequestParamController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class RequestParamControllerTest {
    private MockMvc mockMvc;
    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new RequestParamController()).build();
    }

    // 默认为required
    @Test
    public void requestParam() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/requestParam/defaultRequired")
                .param("petName", "tom")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // 自动类型转换
    @Test
    public void requestParam2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/requestParam/autoTypeConversion")
                .param("age", "22")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // 同名数组或列表
    @Test
    public void requestParam3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/requestParam/arrayOrList")
                .param("name", "tom")
                .param("name", "jerry")
                .param("num", "10")
                .param("num", "20")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // Map 不指定参数或指定参数
    @Test
    public void requestParam4() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/requestParam/map3")
                .param("name", "tom")
//                .param("age", "22")
//                .param("email", "tom@abc.com")
//                .param("name", "jerry")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void requestParam5() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/requestParam/map5")
                .param("name", "tom")
                .param("age", "22")
                .param("email", "tom@abc.com")
                .param("name", "jerry")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void requestParam6() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/requestParam/map8")
                .param("from", "2019-10-23")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void requestParam7() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/requestParam/map9")
                .param("name", "tom")
                .param("age", "23")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}