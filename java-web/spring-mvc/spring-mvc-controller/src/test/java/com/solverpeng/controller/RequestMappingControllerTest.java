package com.solverpeng.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.junit.Assert.*;

public class RequestMappingControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new RequestMappingController()).build();
    }

    @Test
    public void getMapping() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestMapping/get/1")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void postMapping() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/requestMapping/post")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void putMapping() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.put("/requestMapping/put/1")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deleteMapping() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/requestMapping/delete/1")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void patchMapping() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/requestMapping/patch/1")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void uriPatternMapping() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestMapping/uri/indexA")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestMapping/uri/indexB")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void uriPattern2Mapping() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestMapping/uri/indexAA")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestMapping/uri/indexAAA")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void uriPattern3Mapping() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestMapping/uri/index/AA")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestMapping/uri/index/AABB")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void uriPattern4Mapping() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestMapping/uri/index/AA")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestMapping/uri/index/AA/BB")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void pathVariableMapping() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestMapping/pathVariable/1/pets/10")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * 注意响应头：
     * MockHttpServletResponse:
     * Status = 200
     * Error message = null
     * Headers = [Content-Disposition:"inline;filename=f.txt", Content-Type:"application/java-archive;charset=ISO-8859-1", Content-Length:"37"]
     * Content type = application/java-archive;charset=ISO-8859-1
     * Body = regexMapping-> version:3.0.5,ext:.jar
     */
    @Test
    public void regexMapping() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestMapping/spring-web-3.0.5.jar")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * 会导致歧义，不推荐，推荐将后缀匹配禁用
     */
    @Test
    public void SuffixMatchMapping() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestMapping/suffixMatch/person.json")
                .param("name", "张三")
                .characterEncoding("utf-8"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void consumesMapping() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestMapping/consumes")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    /**
     * 不指定accept也会进行映射
     */
    @Test
    public void producesMapping() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestMapping/produces")
//                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void requestParam() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestMapping/requestParam/1")
                .param("myParam", "myValue")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void requestParam2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestMapping/requestParam2/1")
                .param("myParam", "XXX")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void requestParam3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/requestMapping/requestParam3/1")
                .param("myParam", "AAA")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}