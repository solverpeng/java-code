package com.solverpeng.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

}
