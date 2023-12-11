package com.GW.JJOFFICE.JJOFFICE.auth.service;

import com.GW.JJOFFICE.JJOFFICE.auth.dto.ResponseDto;
import com.GW.JJOFFICE.JJOFFICE.auth.dto.SignInDto;
import com.GW.JJOFFICE.JJOFFICE.auth.dto.SignInResponseDto;
import com.GW.JJOFFICE.JJOFFICE.auth.dto.SignUpDto;

public interface AuthService {
    ResponseDto<SignInResponseDto> signIn(SignInDto signInDto);
    ResponseDto<?> signUp(SignUpDto signUpDto);
}
