package com.GW.JJOFFICE.JJOFFICE.menu2.controller;

import com.GW.JJOFFICE.JJOFFICE.menu2.service.Menu2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/menu2")
public class Menu2Controller {
    @Autowired
    private final Menu2Service menu2Service;

    @GetMapping("")
    public String menu2Page() {
        return "menu2/menu2Page";
    }
}
