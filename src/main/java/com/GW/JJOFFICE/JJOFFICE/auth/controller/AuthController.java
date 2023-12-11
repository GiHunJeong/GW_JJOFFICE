package com.GW.JJOFFICE.JJOFFICE.auth.controller;

import com.GW.JJOFFICE.JJOFFICE.auth.dto.EmployeeDto;
import com.GW.JJOFFICE.JJOFFICE.auth.dto.ResponseDto;
import com.GW.JJOFFICE.JJOFFICE.auth.dto.SignInDto;
import com.GW.JJOFFICE.JJOFFICE.auth.dto.SignInResponseDto;
import com.GW.JJOFFICE.JJOFFICE.auth.service.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private final AuthService authService;
    @RequestMapping("/auth")
    public String loginPage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        EmployeeDto employeeDto = (EmployeeDto) session.getAttribute("EmployeeDto");

        if(employeeDto != null) {
            return "redirect:/main";
        } else {
            return "auth/login";
        }
    }
    @RequestMapping("/signIn")
    public String signIn(@RequestBody SignInDto signInDto, Model model, HttpServletResponse response
                        , HttpServletRequest request) {
        ResponseDto<SignInResponseDto> responseDto = authService.signIn(signInDto);
        if(responseDto.isResult()) {
            request.getSession().setAttribute("EmployeeDto", responseDto.getData().getEmployeeDto());
            HttpSession session = request.getSession();
            Cookie cookie = new Cookie("token", responseDto.getData().getToken());
            cookie.setDomain("localhost");
            cookie.setPath("/");
            session.setMaxInactiveInterval(responseDto.getData().getExprTime());
            cookie.setMaxAge(responseDto.getData().getExprTime());
            cookie.setSecure(true);
            response.addCookie(cookie);
        }
        System.out.println(responseDto);
        model.addAttribute("responseDto", responseDto);
        return "jsonView";
    }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }
}