package com.stylefeng.guns.rest.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.persistence.dao.MyUserMapper;
import com.stylefeng.guns.rest.persistence.model.MyUser;
import com.stylefeng.guns.rest.persistence.model.UpdateUserVo;
import com.stylefeng.guns.rest.persistence.model.UserBo;
import com.stylefeng.guns.rest.persistence.model.UserInfoVo;
import com.stylefeng.guns.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;


@Service(interfaceClass = UserService.class)
@Component
public class UserServiceImpl implements UserService{

    @Autowired
    MyUserMapper userMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public boolean register(UserBo userBo) throws Exception{
        return userMapper.register(userBo) == 1;
    }

    @Override
    public boolean UserExist(String username) throws Exception {
        return userMapper.UserExist(username) != null;
    }

    @Override
    public Integer auth(String username, String password) throws Exception {
        return userMapper.auth(username, password);
    }

    @Override
    public HashMap gstToken(String username) throws Exception {
        final String randomKey = jwtTokenUtil.getRandomKey();
        final String token = jwtTokenUtil.generateToken(username, randomKey);
        HashMap hashMap = new HashMap();
        hashMap.put("randomKey",randomKey);
        hashMap.put("token",token);
        return hashMap;
    }

    @Override
    public boolean updatePartialById(UpdateUserVo updateUserVo) throws Exception{
        return userMapper.updatePartialByID(updateUserVo);
    }

    @Override
    public UserInfoVo selectByUserNameUpdate(String userName) throws Exception{
        return userMapper.selectByUserNameUpdate(userName);
    }

    @Override
    public UserInfoVo selectByUserName(String userName) throws Exception{
        return userMapper.selectByUserName(userName);
    }
}
