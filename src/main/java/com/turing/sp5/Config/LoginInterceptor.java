package com.turing.sp5.Config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        if (request.getSession().getAttribute("user")==null){
            log.info("拦截了。。");
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
        return true;
    }
}
