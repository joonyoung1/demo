package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/thymeleaf")
    public String test() {
        return "thymeleaf"; // Should resolve to src/main/resources/templates/test.html
    }
}