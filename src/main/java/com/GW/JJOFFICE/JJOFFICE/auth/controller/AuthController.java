package com.GW.JJOFFICE.JJOFFICE.auth.controller;

import com.GW.JJOFFICE.JJOFFICE.auth.dto.ResponseDto;
import com.GW.JJOFFICE.JJOFFICE.auth.dto.SignInDto;
import com.GW.JJOFFICE.JJOFFICE.auth.dto.SignInResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    @GetMapping("")
    public String loginPage() {
        return "auth/signIn";
    }
    @PostMapping("/signIn")
    public String signIn(SignInDto signInDto) {
        System.out.println("signInDto = "+signInDto);
        return "";
    }
}
