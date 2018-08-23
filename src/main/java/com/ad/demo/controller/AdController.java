package com.ad.demo.controller;

import com.ad.demo.model.Ad;
import com.ad.demo.repository.AdRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/ad")
public class AdController {

    @Autowired
    AdRepository adRepository;

    @Value("${ad-app.ad.pic.url}")
    private String adPicDir;

    @PostMapping("/add")

    public String add(@ModelAttribute Ad ad, @RequestParam("image")MultipartFile multipartFile){
        File fileDir = new File(adPicDir);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }
        String picName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        try {
            multipartFile.transferTo(new File(fileDir,picName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ad.setPicUrl(picName);
        adRepository.save(ad);
        return "redirect:/adminHome";
    }

    @GetMapping(value = "/adImage")
    public @ResponseBody
    byte[] userImage(@RequestParam("picUrl") String picUrl) throws IOException {
        InputStream in = new FileInputStream(adPicDir + picUrl);
        return IOUtils.toByteArray(in);
    }
}
