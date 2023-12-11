package com.GW.JJOFFICE.JJOFFICE.auth.controller;

import com.GW.JJOFFICE.JJOFFICE.auth.dto.ResponseDto;
import com.GW.JJOFFICE.JJOFFICE.auth.dto.SignInDto;
import com.GW.JJOFFICE.JJOFFICE.auth.dto.SignInResponseDto;
import com.GW.JJOFFICE.JJOFFICE.auth.security.TokenProvider;
import com.GW.JJOFFICE.JJOFFICE.auth.service.AuthService;
import jakarta.servlet.http.Cookie;
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
    @Autowired
    private final TokenProvider tokenProvider;
    //@GetMapping("")
    @RequestMapping("/auth")
    public String loginPage() {
        return "auth/login";
    }
    /*@PostMapping("/signIn")
    public String signIn(SignInDto signInDto) {
        System.out.println("signInDto = "+signInDto);
        return "";
    }*/
    //@PostMapping("/signIn")
    @RequestMapping("/signIn")
    public String signIn(@RequestBody SignInDto signInDto, Model model) {
        ResponseDto<SignInResponseDto> responseDto = authService.signIn(signInDto);
        System.out.println(responseDto);
        System.out.println(tokenProvider.validate(responseDto.getData().getToken()));
        model.addAttribute("responseDto", responseDto);
        return "jsonView";
    }
}