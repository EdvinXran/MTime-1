package com.stylefeng.guns.rest.service;

import com.stylefeng.guns.rest.persistence.model.UserBo;

import java.util.HashMap;

public interface UserService {

    public boolean register(UserBo userBo) throws Exception;

    public boolean UserExist(String username) throws Exception;

    public boolean auth(String username,String password) throws Exception;

    public HashMap gstToken(String username) throws Exception;
}
