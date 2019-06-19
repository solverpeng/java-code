package com.solverpeng.controller.handlermethod;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.File;
import java.io.FileInputStream;

import static org.junit.Assert.*;

public class MultipartControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new MultipartController()).build();
    }

    @Test
    public void fileUpload() throws Exception {
        File uploadFile = new File("D:/upload.txt");
        MockMultipartFile file = new MockMultipartFile("file", "originFileName",
                "multipart/form-data", new FileInputStream(uploadFile));

        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.multipart("/multipart/upload").file(file).param("name", "tom");
        mockMvc.perform(requestBuilder
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                .characterEncoding("utf-8")
        ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }


    @Test
    public void multiFileUpload() throws Exception {
        File uploadFile = new File("D:/upload.txt");
        File uploadFile2 = new File("D:/upload2.txt");
        MockMultipartFile file = new MockMultipartFile("file", new FileInputStream(uploadFile));
        MockMultipartFile file2 = new MockMultipartFile("file", new FileInputStream(uploadFile2));

        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.multipart("/multipart/upload2").file(file).file(file2).param("name", "tom");
        mockMvc.perform(requestBuilder
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                .characterEncoding("utf-8")
        ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    public void multiFileUpload2() throws Exception {
        File uploadFile = new File("D:/upload.txt");
        File uploadFile2 = new File("D:/upload2.txt");
        MockMultipartFile file = new MockMultipartFile("file", new FileInputStream(uploadFile));
        MockMultipartFile file2 = new MockMultipartFile("file", new FileInputStream(uploadFile2));

        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.multipart("/multipart/upload3").file(file).file(file2).param("name", "jerry");
        mockMvc.perform(requestBuilder
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                .characterEncoding("utf-8")
        ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    public void multipartForm() throws Exception {
        File uploadFile = new File("D:/upload.txt");
        MockMultipartFile file = new MockMultipartFile("file", new FileInputStream(uploadFile));

        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.multipart("/multipart/upload4").file(file).param("name", "tom");
        mockMvc.perform(requestBuilder
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                .characterEncoding("utf-8")
        ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }
}