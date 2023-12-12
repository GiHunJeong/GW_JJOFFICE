package com.GW.JJOFFICE.config;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@RequiredArgsConstructor
public class WebSecrurityConfig {
    @Autowired
    private final LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private final LoginFailureHandler loginFailureHandler;
    @Bean
    public PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable())
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers("/resources/**", "/js/**", "/WEB-INF/views/**").permitAll() // 허용하는 경로들
                        .requestMatchers("/admin/**").hasRole("Admin") // Admin 권한만 접근 가능
                        .anyRequest().authenticated()	// 어떠한 요청이라도 인증필요
                )
                .formLogin(login -> login	// form 방식 로그인 사용
                        .loginPage("/auth")	// [A] 커스텀 로그인 페이지 지정
                        .loginProcessingUrl("/signIn")	// [B] submit 받을 url
                        .usernameParameter("empLoginId")	// [C] submit할 아이디
                        .passwordParameter("empLoginPw")	// [D] submit할 비밀번호
                        .successHandler(loginSuccessHandler)
                        .failureHandler(loginFailureHandler)
                        //.defaultSuccessUrl("/main", true)	// 성공 시 /main 으로
                        .permitAll()	// 대시보드 이동이 막히면 안되므로 얘는 허용
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // 커스텀 로그아웃
                        .logoutSuccessUrl("/") // 로그아웃 실행후 url
                        .invalidateHttpSession(true) // 로그아웃 후 세션 삭제
                        .deleteCookies("JSESSIONID"));	// 쿠키에 저장된 "JSESSIONID" 삭제
                /*.rememberMe(customizer -> customizer
                        .rememberMeParameter("remember-me")
                        .tokenValiditySeconds(ONE_MONTH)
                        .userDetailsService(memberDetailsService)
                        .authenticationSuccessHandler(new LoginSuccessHandler())
                )*/
        return http.build();
    }
}
