package com.GW.JJOFFICE.JJOFFICE.auth.service;

import com.GW.JJOFFICE.JJOFFICE.auth.dto.*;

public interface AuthService {
    //ResponseDto<SignInResponseDto> signIn(SignInDto signInDto);
    ResponseDto<?> signUp(SignUpDto signUpDto);
}
