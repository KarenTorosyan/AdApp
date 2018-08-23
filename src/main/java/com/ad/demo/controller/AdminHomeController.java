package com.ad.demo.controller;

import com.ad.demo.model.Category;
import com.ad.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminHomeController {

    @GetMapping
    public String home() {
        return "admin_home";
    }

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/adminHome")
    public String adminHome(ModelMap modelMap) {
        List<Category> categories = categoryRepository.findAll();
        modelMap.addAttribute("categories", categories);
        return "admin_home";

    }
}
