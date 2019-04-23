package com.stylefeng.guns.rest.modular.user;


import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.persistence.model.UserBo;
import com.stylefeng.guns.rest.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;


@RequestMapping("/user")
@Component
public class UserController {

    @Reference
    UserService userService;

    @RequestMapping(value = "/register",method = {RequestMethod.POST})
    @ResponseBody
    public HashMap register(UserBo userBo){
        HashMap hashMap = new HashMap();
        try {
            boolean exist = userService.UserExist(userBo.getUsername());
            if(!exist) {
                boolean ret = userService.register(userBo);
                if (ret) {
                    hashMap.put("msg", "注册成功");
                    hashMap.put("status", 0);
                }else{
                    hashMap.put("msg", "系统出现异常，请联系管理员");
                    hashMap.put("status", 999);
                }
            }else{
                hashMap.put("msg", "用户已存在");
                hashMap.put("status", 1);
            }
        } catch (Exception e) {
            hashMap.put("msg", "系统出现异常，请联系管理员");
            hashMap.put("status", 999);
            e.printStackTrace();
        }
        return hashMap;
    }

    @RequestMapping(value = "/check",method = {RequestMethod.POST})
    @ResponseBody
    public HashMap check(String username){
        HashMap hashMap = new HashMap();
        try {
            boolean exist = userService.UserExist(username);
            if(exist) {
                hashMap.put("msg", "用户已存在");
                hashMap.put("status", 1);

            }else{
                hashMap.put("msg", "验证成功");
                hashMap.put("status", 0);
            }
        } catch (Exception e) {
            hashMap.put("msg", "系统出现异常，请联系管理员");
            hashMap.put("status", 999);
            e.printStackTrace();
        }
        return hashMap;
    }

    @RequestMapping(value = "/auth",method = {RequestMethod.POST})
    @ResponseBody
    public HashMap auth(String username,String password){
        HashMap hashMap = new HashMap();
        try {
            boolean auth = userService.auth(username, password);
            if(auth) {
                HashMap token = userService.gstToken(username);
                hashMap.put("date", token);
                hashMap.put("status", 0);
            }else{
                hashMap.put("msg", "用户名或密码错误");
                hashMap.put("status", 1);
            }
        } catch (Exception e) {
            hashMap.put("msg", "系统出现异常，请联系管理员");
            hashMap.put("status", 999);
            e.printStackTrace();
        }
        return hashMap;
    }
}

