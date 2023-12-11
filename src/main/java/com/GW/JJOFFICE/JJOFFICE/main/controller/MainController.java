package com.GW.JJOFFICE.JJOFFICE.main.controller;

import com.GW.JJOFFICE.JJOFFICE.auth.dto.EmployeeDto;
import com.GW.JJOFFICE.JJOFFICE.main.service.MainService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    @Autowired
    private final MainService mainService;
    @GetMapping("")
    public String indexPage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        EmployeeDto employeeDto = (EmployeeDto) session.getAttribute("EmployeeDto");

        if(employeeDto != null) {
            return "redirect:/main";
        } else {
            return "redirect:/auth";
        }
    }
    @GetMapping("main")
    public String mainPage() {
        return "main/mainPage";
    }
}
