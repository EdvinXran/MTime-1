package com.stylefeng.guns.rest.modular.user;


import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.persistence.model.*;
import com.stylefeng.guns.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;


@RequestMapping("/user")
@Component
public class UserController {

    @Reference
    UserService userService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

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

    @RequestMapping("/logout")
    @ResponseBody
    public Object logout(@RequestHeader("Authorization") String auth) {
        return UserVoEnum.LOGOUT_SERVICE_SUCCESS;
    }

    /**
     *  userInfo
     * @param auth
     * @return
     */
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserInfo(@RequestHeader("Authorization") String auth) {
        String username = jwtTokenUtil.getUsernameFromToken(auth.substring(auth.indexOf(" ")));
        UserInfoVo user = null;
        try {
            user = userService.selectByUserName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            return UserVoEnum.GETUSERINFO_SERVICE_EXCEPTION;
        }
        /**
         * 枚举 UserVoEnum 用法见定义
         */
        return UserVoEnum.GETUSERINFO_SERVICE_SUCCESS.setData(user);
    }

    @RequestMapping("/updateUserInfo")
    @ResponseBody
    public Object updateUserInfo(@ModelAttribute UpdateUserVo updateUserVo) {
        if (updateUserVo == null)
            return null;
        updateUserVo.setUpdateTime(new Date());
        boolean b = false;
        try {
            b = userService.updatePartialById(updateUserVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!b) {
            return UserVoEnum.UPDATEUSERINFO_SERVICE_EXCEPTION;
        }
        UserInfoVo UserVo = null;
        try {
            UserVo = userService.selectByUserNameUpdate(updateUserVo.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return UserVoEnum.UPDATEUSERINFO_SERVICE_SUCCESS.setData(UserVo);
    }

}

