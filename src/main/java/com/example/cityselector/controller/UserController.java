package com.example.cityselector.controller;

import com.example.cityselector.dto.CurrentPointDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/select")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String selectionPage(@Value("${prolog.url.current}") String currentPointUrl,
                                Model model) {
        CurrentPointDto currentPoint = restTemplate.getForObject(currentPointUrl, CurrentPointDto.class);
        model.addAttribute("currentPoint", currentPoint);
        return "main";
    }

    @PostMapping("/yes")
    public String yesAnswer(@Value("${prolog.url.yes}") String yesAnswerUrl) {
        restTemplate.postForObject(yesAnswerUrl, null, Object.class);
        return "redirect:/select";
    }

    @PostMapping("/no")
    public String noAnswer(@Value("${prolog.url.no}") String noAnswerUrl) {
        restTemplate.postForObject(noAnswerUrl, null, Object.class);
        return "redirect:/select";
    }

    @GetMapping("/reset")
    public String reset(@Value("${prolog.url.reset}") String currentPointUrl,
                                Model model) {
        CurrentPointDto currentPoint = restTemplate.getForObject(currentPointUrl, CurrentPointDto.class);
        model.addAttribute("currentPoint", currentPoint);
        return "redirect:/select";
    }
}