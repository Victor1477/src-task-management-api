package com.task.management.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping()
    public String sendHomeView() {
        return "index.html";
    }
}
