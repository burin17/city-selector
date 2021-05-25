package com.example.cityselector.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/start")
public class StartController {
    @GetMapping
    public String getStartPage() {
        return "start";
    }
}
