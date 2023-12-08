package com.GW.JJOFFICE.JJOFFICE.main.controller;

import com.GW.JJOFFICE.JJOFFICE.main.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    @Autowired
    private final MainService mainService;
    @GetMapping("")
    public String indexPage() {
        return "index";
    }
    @GetMapping("main")
    public String mainPage() {
        return "main/mainPage";
    }
}
