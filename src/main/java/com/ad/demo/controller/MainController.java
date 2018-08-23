package com.ad.demo.controller;

import com.ad.demo.model.Ad;
import com.ad.demo.model.Category;
import com.ad.demo.repository.AdRepository;
import com.ad.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String main() {
        return "redirect:/home";
    }

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AdRepository adRepository;

    @GetMapping("/home")
    public String adminHome(ModelMap modelMap) {
        List<Category> categories = categoryRepository.findAll();
        modelMap.addAttribute("categories", categories);
        List<Ad> ads = adRepository.findAll();
        modelMap.addAttribute("ads", ads);
        return "home";

    }
}
