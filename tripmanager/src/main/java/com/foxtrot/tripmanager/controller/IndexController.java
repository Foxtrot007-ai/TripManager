package com.foxtrot.tripmanager.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public class IndexController {
    @GetMapping("/")
    public String viewHomePage(Model model) {
        return "index";
    }
}
