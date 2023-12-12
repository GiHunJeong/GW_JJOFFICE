package com.GW.JJOFFICE.JJOFFICE.auth.service.Impl;

import com.GW.JJOFFICE.JJOFFICE.auth.dto.*;
import com.GW.JJOFFICE.JJOFFICE.auth.repository.AuthRepository;
import com.GW.JJOFFICE.JJOFFICE.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    @Autowired
    private final AuthRepository authRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    /*@Autowired
    private final TokenProvider tokenProvider;*/

    /*@Override
    public ResponseDto<SignInResponseDto> signIn(SignInDto signInDto) {
        String empId = signInDto.getEmpLoginId();
        String empPw = signInDto.getEmpLoginPw();

        EmployeeDto employeeDto = null;
        try {
            employeeDto = authRepository.findByEmpId(empId);
            // 잘못된 이메일
            if (employeeDto == null) return ResponseDto.setFailed("Sign In Failed(Not Found Id)");
            // 잘못된 패스워드
            if (!passwordEncoder.matches(empPw, employeeDto.getEmpLoginPw()))
            //if (!empPw.equals(employeeDto.getEmpLoginPw()))
                return ResponseDto.setFailed("Sign In Failed(Password Do Not Match)");
        } catch (Exception e) {
            return ResponseDto.setFailed("Database Error");
        }

        employeeDto.setEmpLoginPw("");

        //String token = tokenProvider.create(empId);
        String token = "notToken";
        int exprTime = 3600000;

        SignInResponseDto signInResponseDto = new SignInResponseDto(token, exprTime, employeeDto);
        return ResponseDto.setSuccess("Sign in Success", signInResponseDto);
    }*/
    public ResponseDto<?> signUp(SignUpDto signUpDto) {
        String empId = signUpDto.getEmpLoginId();
        String empPw = signUpDto.getEmpLoginPw();
        String empPwChk = signUpDto.getEmpLoginPwChk();

        // email 중복 확인
        try {
            if (authRepository.existsById(empId))
                return ResponseDto.setFailed("중복된 이메일 입니다.");
        } catch (Exception e) {
            return ResponseDto.setFailed("Data Base Error!");
        }

        // 비밀번호가 서로 다르면 failed response 반환!
        if(!empPw.equals(empPwChk))
            return ResponseDto.setFailed("비밀번호와 비밀번호체크가 일치하지 않습니다.");
        // 임시 권한 설정
        signUpDto.setRole("User");
        // UserEntity 생성
        EmployeeDto employeeDto = new EmployeeDto(signUpDto);

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(empPw);
        employeeDto.setEmpLoginPw(encodedPassword);

        // UserRepository를 이용해서 데이터베이스에 Entity 저장
        try {
            authRepository.empInfoSave(employeeDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed("Data Base Error!");
        }

        // 성공시 success response 반환
        return ResponseDto.setSuccess("SignUp Success!", null);
    }
}
