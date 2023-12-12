package com.GW.JJOFFICE.JJOFFICE.main.controller;

import com.GW.JJOFFICE.JJOFFICE.auth.dto.EmployeeDto;
import com.GW.JJOFFICE.JJOFFICE.auth.service.AuthService;
import com.GW.JJOFFICE.JJOFFICE.main.service.MainService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class MainController {
    @Autowired
    private final MainService mainService;
    @Autowired
    private final AuthService authService;
    @RequestMapping("/")
    public String indexPage() {
        return "redirect:/main";
    }
    /*@RequestMapping( "/main")
    public String mainPage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        EmployeeDto employeeDto = (EmployeeDto) session.getAttribute("EmployeeDto");
        if(employeeDto != null) {
            model.addAttribute("userName", employeeDto.getEmpName());
            return "main/mainPage";
        } else {
            return "redirect:/auth";
        }
    }*/
    @PreAuthorize("isAuthenticated()") // 인증 로그인되었을때
    @RequestMapping("/main")
    public String mainPage(HttpSession session, HttpServletRequest request, Model model) {
        EmployeeDto employeeDto = (EmployeeDto) session.getAttribute("EmployeeDto");
        model.addAttribute("empInfo", employeeDto);
        if (session.getAttribute("msg") != null) {
            request.setAttribute("msg", session.getAttribute("msg"));
            session.removeAttribute("msg");
            model.addAttribute("msg", request.getAttribute("msg"));
        }
        System.out.println(employeeDto);
        return "main/mainPage";
    }
}
