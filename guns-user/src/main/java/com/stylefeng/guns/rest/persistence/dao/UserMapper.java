package com.stylefeng.guns.rest.persistence.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.persistence.model.User;
import com.stylefeng.guns.rest.persistence.model.UserBo;
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
public interface UserMapper extends BaseMapper<User> {

    @Insert("insert into user(user_name,user_pwd,email,user_phone,address) values(#{username},#{password},#{email},#{phone},#{address})")
    public int register(UserBo userBo) throws Exception;

    @Select("select * from user where user_name = #{username}")
    public UserBo UserExist(String username) throws Exception;

    @Select("select * from user where user_name = #{username} and user_pwd = #{password}")
    public UserBo auth(String username,String password) throws Exception;
}
