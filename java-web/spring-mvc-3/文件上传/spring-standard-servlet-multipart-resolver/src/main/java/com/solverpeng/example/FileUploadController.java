package com.solverpeng.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
    public static final String targetFolder=  "d:/filesUploaded/";

    @GetMapping
    public String handleGet() {
        return "file-upload";
    }

    @PostMapping
    public String handlePost(MultipartHttpServletRequest request, Model model) throws IOException {
        MultipartFile multipartFile = request.getFile("user-file");
        String name = multipartFile.getOriginalFilename();
        InputStream inputStream = multipartFile.getInputStream();

        Files.copy(inputStream, Paths.get(targetFolder + name), StandardCopyOption.REPLACE_EXISTING);
        model.addAttribute("msg", "File has been uploaded:  " + name);
        return "response";
    }

}
