package com.GW.JJOFFICE.JJOFFICE.menu3.controller;

import com.GW.JJOFFICE.JJOFFICE.menu3.service.Menu3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/menu3")
public class Menu3Controller {
    @Autowired
    private final Menu3Service menu3Service;

    @GetMapping("")
    public String menu3Page() {
        return "menu3/menu3Page";
    }
}
