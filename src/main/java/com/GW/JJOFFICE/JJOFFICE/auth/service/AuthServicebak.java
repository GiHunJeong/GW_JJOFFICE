/*
package com.GW.JJOFFICE.JJOFFICE.auth.service;

import com.GW.JJOFFICE.JJOFFICE.auth.dto.*;
import com.GW.JJOFFICE.JJOFFICE.auth.repository.AuthRepository;
import com.GW.JJOFFICE.JJOFFICE.auth.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    AuthRepository authRepository;
    @Autowired
    TokenProvider tokenProvider;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    */
/*public ResponseDto<?> signUp(SignUpDto signUpDto) {
        String empId = signUpDto.getEmpLoginId();
        String empPw = signUpDto.getEmpLoginPw();
        String empPwChk = signUpDto.getEmpLoginPwChk();

        // email 중복 확인
        try {
            if (userRepository.existsById(empId))
                return ResponseDto.setFailed("Existed Email!");
        } catch (Exception e) {
            return ResponseDto.setFailed("Data Base Error!");
        }

        // 비밀번호가 서로 다르면 failed response 반환!
        if(!empPw.equals(empPwChk))
            return ResponseDto.setFailed("password does not matched!");

        // UserEntity 생성
        EmployeeDto employeeDto = new EmployeeDto(signUpDto);

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(empPw);
        employeeDto.setEmpLoginPw(encodedPassword);

        // UserRepository를 이용해서 데이터베이스에 Entity 저장
        try {
            userRepository.save(employeeDto);
        } catch (Exception e) {
            return ResponseDto.setFailed("Data Base Error!");
        }

        // 성공시 success response 반환
        return ResponseDto.setSuccess("Signup Success!", null);
    }*//*


    public ResponseDto<SignInResponseDto> signIn(SignInDto signInDto) {
        String empId = signInDto.getEmpLoginId();
        String empPw = signInDto.getEmpLoginPw();

        EmployeeDto employeeDto = null;
        try {
            employeeDto = authRepository.findByEmpId(empId); // 수정해야함
            // 잘못된 이메일
            if (employeeDto == null) return ResponseDto.setFailed("Sign In Failed");
            // 잘못된 패스워드
            //if (!passwordEncoder.matches(empPw, employeeDto.getEmpLoginPw()))
            if (empPw.equals(employeeDto.getEmpLoginPw().toString()))
                return ResponseDto.setFailed("Sign In Failed");
        } catch (Exception e) {
            return ResponseDto.setFailed("Database Error");
        }

        employeeDto.setEmpLoginPw("");

        String token = tokenProvider.create(empId);
        int exprTime = 3600000;

        SignInResponseDto signInResponseDto = new SignInResponseDto(token, exprTime, employeeDto);
        return ResponseDto.setSuccess("Sign in Success", signInResponseDto);
    }
}*/
