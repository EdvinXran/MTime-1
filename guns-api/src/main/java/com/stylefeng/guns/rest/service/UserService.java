package com.stylefeng.guns.rest.service;

import com.stylefeng.guns.rest.persistence.model.MyUser;
import com.stylefeng.guns.rest.persistence.model.UpdateUserVo;
import com.stylefeng.guns.rest.persistence.model.UserBo;
import com.stylefeng.guns.rest.persistence.model.UserInfoVo;

import java.util.HashMap;

public interface UserService {

    public boolean register(UserBo userBo) throws Exception;

    public boolean UserExist(String username) throws Exception;

    public Integer auth(String username,String password) throws Exception;

    public HashMap gstToken(String username) throws Exception;

    UserInfoVo selectByUserName(String userName) throws Exception;

    UserInfoVo selectByUserNameUpdate(String userName) throws Exception;

    @Deprecated
    boolean updatePartialById(UpdateUserVo updateUserVo) throws Exception;
}
