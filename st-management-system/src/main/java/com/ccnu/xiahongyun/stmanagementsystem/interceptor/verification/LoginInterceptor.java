package com.ccnu.xiahongyun.stmanagementsystem.interceptor.verification;

import com.ccnu.xiahongyun.stmanagementsystem.Utils.TokenUtils;
import com.ccnu.xiahongyun.stmanagementsystem.model.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class LoginInterceptor implements HandlerInterceptor{
    private final TokenUtils tokenUtils;

    @Autowired
    public LoginInterceptor(TokenUtils tokenUtils){
        this.tokenUtils = tokenUtils;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String uri = httpServletRequest.getRequestURI();

        Cookie[] cookies = httpServletRequest.getCookies();

        if(cookies == null){
            httpServletResponse.sendRedirect("/exception/refuse");
            return false;
        }


        String token = null;
        //获取cookie中token
        for(Cookie cookie : cookies){
            if("token".equals(cookie.getName())){
                token = cookie.getValue();
            }
        }

        if(token==null){
            httpServletResponse.sendRedirect("/exception/verification");
            return false;
        }

        //验证username和token的正确性
        List<String> userList = tokenUtils.getUserList();
        String username = tokenUtils.getUsernameFromToken(token);
        if (userList.contains(username)){
           return true;
        }

        httpServletResponse.sendRedirect("/exception/verification");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
