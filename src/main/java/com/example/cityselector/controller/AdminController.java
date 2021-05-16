package com.example.cityselector.controller;

import com.example.cityselector.domain.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String adminPage(@Value("${prolog.url.all}") String allPointsUrl,
                           Model model) {
        Point rootPoint = restTemplate.getForObject(allPointsUrl, Point.class);
        model.addAttribute("rootPoint",rootPoint);
        return "admin";
    }

    @GetMapping("/tree")
    @ResponseBody
    public Point jsonTree(@Value("${prolog.url.all}") String allPointsUrl) {
        return restTemplate.getForObject(allPointsUrl, Point.class);
    }

    @PostMapping("/modify/{id}")
    public String modifyPointTitle(@PathVariable int id, @RequestParam String title,
                              @Value("${prolog.url.modify.title}") String modifyPointUrl) {
        restTemplate.postForObject(modifyPointUrl,
                new Point(id, title), Point.class);
        return "redirect:/admin";
    }

    @PostMapping("/modify/{id}/type")
    public String modifyPointType(@PathVariable int id,
                                  @Value("${prolog.url.modify.type}") String modifyTypeUrl) {
        restTemplate.postForObject(modifyTypeUrl,
                new Point(id, null), Point.class);
        return "redirect:/admin";
    }
}
