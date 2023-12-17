package com.GW.JJOFFICE.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {
    //실제 controller(handler)가 실행되기 전에 실행되며 boolean 타입의 값을 return 한다. true이면 요청한 handler를 처리하고 false이면 처리하지 않는다.
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        return false;
    }
    //handler가 실행된 후에 실행된다.
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    //전체 요청이 끝나고 난 후 마지막에 실행된다.
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
