package com.GW.JJOFFICE.config;

import com.GW.JJOFFICE.JJOFFICE.auth.dto.EmployeeDto;
import com.GW.JJOFFICE.JJOFFICE.auth.repository.AuthRepository;
import com.GW.JJOFFICE.JJOFFICE.auth.service.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    private final AuthRepository authRepository;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String empLoginId = authentication.getName(); // 로그인 아이디

        EmployeeDto employeeDto = authRepository.findByEmpId(empLoginId); // 해당 아이디 이용자 정보

        request.getSession().setAttribute("msg", employeeDto.getEmpName()+" 님 로그인 하셨습니다.");
        request.getSession().setAttribute("EmployeeDto", employeeDto);

        new DefaultRedirectStrategy().sendRedirect(request, response, "/main");
    }
}
