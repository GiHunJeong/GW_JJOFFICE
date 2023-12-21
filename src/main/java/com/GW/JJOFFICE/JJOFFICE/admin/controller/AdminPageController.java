package com.GW.JJOFFICE.JJOFFICE.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminPageController {
    @GetMapping("")
    public String adminPage() {
        return "admin/adminPage";
    }
}
