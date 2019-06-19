package com.solverpeng.controller.handlermethod;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Controller
@RequestMapping("/multipart")
public class MultipartController {


    @ResponseBody
    @PostMapping("/upload")
    public String fileUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            return "multipart->upload success->name:" + name + ",bytes length:" + bytes.length;
        }
        return "multipart->upload failure->name:" + name;
    }
    @ResponseBody
    @PostMapping("/upload2")
    public String fileUpload2(@RequestParam("name") String name, @RequestParam("file") List<MultipartFile> files) {
        if (!CollectionUtils.isEmpty(files)) {
            return "multipart->multi file upload success->name:" + name + ",file size:" + files.size();
        }
        return "multipart->multi file upload failure->name:" + name;
    }

    @ResponseBody
    @PostMapping("/upload3")
    public String fileUpload3(@RequestParam("name") String name, @RequestParam Map<String,MultipartFile> fileMap) {
        Set<String> mapKeys = fileMap.keySet();
        for (String mapKey : mapKeys) {
            MultipartFile multipartFile = fileMap.get(mapKey);
            System.out.println("mapKey=" + mapKey + ",multipartFileName=" + multipartFile.getName());
        }
        return "multipart->multi file upload->name:" + name ;
    }

    @ResponseBody
    @PostMapping("/upload4")
    public String multipartForm(MultipartForm multipartForm) {
        String name = multipartForm.getName();
        MultipartFile file = multipartForm.getFile();
        return "multipart->multi file upload->name:" + name +",file name:" + file.getName();
    }

}
