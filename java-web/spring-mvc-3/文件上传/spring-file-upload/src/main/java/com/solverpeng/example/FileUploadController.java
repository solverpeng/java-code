package com.solverpeng.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
@RequestMapping("/upload")
public class FileUploadController {

    @GetMapping
    public String handleGet() {
        return "file-upload";
    }

    @PostMapping
    public String handlePost(@RequestParam("user-file") MultipartFile multipartFile, Model model) {
        String filename = multipartFile.getOriginalFilename();
        System.out.println(filename);
        model.addAttribute("msg", "File has been uploaded: " + filename);
        return "response";
    }

    @PostMapping("/multipartHttpServletRequest")
    public String handlePost2(MultipartHttpServletRequest multipartRequest, Model model) throws IOException {
        MultipartFile file = multipartRequest.getFile("user-file");
        String name = file.getOriginalFilename();
        BufferedWriter w = Files.newBufferedWriter(Paths.get("d:/filesUploaded/" + name));
        w.write(new String(file.getBytes()));
        w.flush();

        model.addAttribute("msg", "File has been uploaded:  "+name);
        return "response";
    }

}
