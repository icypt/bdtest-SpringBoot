package com.bdtest.learn.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class TestController {

    @GetMapping("/toUpload")
    public String toUpload() {
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(MultipartFile file, Model model) {
        String saveDir = "E:/upload/";
        String fileName = file.getOriginalFilename();
        File newFile =new File(saveDir + fileName);
        if(!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            return "upload";
        }
        model.addAttribute("viewPath","locResources/"+fileName);
        return "upload";
    }

}
