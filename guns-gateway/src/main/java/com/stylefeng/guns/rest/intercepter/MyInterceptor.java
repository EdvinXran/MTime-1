package com.stylefeng.guns.rest.intercepter;

import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.utils.JedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class MyInterceptor implements HandlerInterceptor {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        if(authorization != null) {
            int index = authorization.indexOf(" ");
            String token = authorization.substring(index + 1);
            String usernameFromToken = jwtTokenUtil.getUsernameFromToken(token);
            Boolean sismember = JedisUtils.getJedisFromPool().exists(usernameFromToken);
            if(sismember){
                request.setAttribute("token", token);
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
