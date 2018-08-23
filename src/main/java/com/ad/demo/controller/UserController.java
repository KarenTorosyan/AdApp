package com.ad.demo.controller;

import com.ad.demo.model.User;
import com.ad.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/add")
    public String add(@ModelAttribute User user) {
        userRepository.save(user);
        return "/redirect:/home";
    }

}
