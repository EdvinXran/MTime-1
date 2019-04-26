package com.stylefeng.guns.rest.persistence.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.common.persistence.model.User;
import com.stylefeng.guns.rest.persistence.model.MyUser;
import com.stylefeng.guns.rest.persistence.model.UpdateUserVo;
import com.stylefeng.guns.rest.persistence.model.UserBo;
import com.stylefeng.guns.rest.persistence.model.UserInfoVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author wxy
 * @since 2019-04-22
 */
@Mapper
public interface MyUserMapper extends BaseMapper<MyUser> {

    @Insert("insert into mtime_user_t(user_name,user_pwd,email,user_phone,address) values(#{username},#{password},#{email},#{phone},#{address})")
    public int register(UserBo userBo) throws Exception;

    @Select("select * from mtime_user_t where user_name = #{username}")
    public UserBo UserExist(String username) throws Exception;

    @Select("select * from mtime_user_t where user_name = #{username} and user_pwd = #{password}")
    public Integer auth(String username,String password) throws Exception;

    UserInfoVo selectByUserName(String userName) throws Exception;

    UserInfoVo selectByUserNameUpdate(String userName) throws Exception;

    @Deprecated
    boolean updatePartialByID(UpdateUserVo updateUserVo) throws Exception;
}
