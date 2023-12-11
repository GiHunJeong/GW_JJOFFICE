package com.GW.JJOFFICE.JJOFFICE.auth.service.Impl;

import com.GW.JJOFFICE.JJOFFICE.auth.dto.EmployeeDto;
import com.GW.JJOFFICE.JJOFFICE.auth.dto.ResponseDto;
import com.GW.JJOFFICE.JJOFFICE.auth.dto.SignInDto;
import com.GW.JJOFFICE.JJOFFICE.auth.dto.SignInResponseDto;
import com.GW.JJOFFICE.JJOFFICE.auth.repository.AuthRepository;
import com.GW.JJOFFICE.JJOFFICE.auth.security.TokenProvider;
import com.GW.JJOFFICE.JJOFFICE.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.apache.el.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    @Autowired
    private final AuthRepository authRepository;
    @Autowired
    private final TokenProvider tokenProvider;

    @Override
    public ResponseDto<SignInResponseDto> signIn(SignInDto signInDto) {
        String empId = signInDto.getEmpLoginId();
        String empPw = signInDto.getEmpLoginPw();

        EmployeeDto employeeDto = null;
        try {
            employeeDto = authRepository.findByEmpId(empId);
            // 잘못된 이메일
            if (employeeDto == null) return ResponseDto.setFailed("Sign In Failed(Not Found Id)");
            // 잘못된 패스워드
            //if (!passwordEncoder.matches(empPw, employeeDto.getEmpLoginPw()))
            if (!empPw.equals(employeeDto.getEmpLoginPw()))
                return ResponseDto.setFailed("Sign In Failed(Password Do Not Match)");
        } catch (Exception e) {
            return ResponseDto.setFailed("Database Error");
        }

        employeeDto.setEmpLoginPw("");

        String token = tokenProvider.create(empId);
        //String token = "testToken";
        int exprTime = 3600000;

        SignInResponseDto signInResponseDto = new SignInResponseDto(token, exprTime, employeeDto);
        return ResponseDto.setSuccess("Sign in Success", signInResponseDto);
    }
}
