package com.GW.JJOFFICE.config;

import com.GW.JJOFFICE.JJOFFICE.auth.dto.EmployeeDto;
import com.GW.JJOFFICE.JJOFFICE.auth.repository.AuthRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private final AuthRepository authRepository;
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        String empLoginId = request.getParameter("empLoginId"); // 사용자가 입력한 아이디

        EmployeeDto employeeDto = authRepository.findByEmpId(empLoginId); // 해당 아이디로 조회

        HttpSession session = request.getSession(); // 세션을 불러옴

        if (employeeDto == null) {
            session.setAttribute("msg", "해당 아이디를 찾을 수 없습니다.");
        } else if (exception instanceof BadCredentialsException) { // 아이디나 비밀번호가 틀렸을때 발생하는 예외
            session.setAttribute("msg", "비밀번호가 틀렸습니다.");
        }

        new DefaultRedirectStrategy().sendRedirect(request, response, "/auth");
    }
}
