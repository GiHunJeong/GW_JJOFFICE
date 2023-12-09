package com.GW.JJOFFICE.JJOFFICE.menu1.controller;

import com.GW.JJOFFICE.JJOFFICE.menu1.service.Menu1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu1")
@RequiredArgsConstructor
public class Menu1Controller {
    @Autowired
    private final Menu1Service menu1Service;

    @GetMapping("")
    public String Menu1Page() {
        return "menu1/menu1Page";
    }
}
