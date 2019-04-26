package com.stylefeng.guns.rest.persistence.model;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.JSONSerializable;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * 该枚举类型定义了返回给前端的消息JSON
 *
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UserVoEnum implements JSONSerializable {
    /**
     * 各个枚举类型的名字语义清晰
     *
     */
    /**
     * logout
     */
    LOGOUT_SERVICE_SUCCESS(0, "成功退出"),
    LOGOUT_SERVICE_EXCEPTION(1, "退出失败，用户尚未登陆"),
    LOGOUT_SYSTEM_EXCEPTION(999, "系统出现异常，请联系管理员"),

    /**
     * getUserInfo
     */
    GETUSERINFO_SERVICE_SUCCESS(0, ""),
    GETUSERINFO_SERVICE_EXCEPTION(1, "查询失败，用户尚未登陆"),
    GETUSERINFO_SYSTEM_EXCEPTION(999, "系统出现异常，请联系管理员"),
    /**
     * updateUserInfo
     */
    UPDATEUSERINFO_SERVICE_SUCCESS(0,""),
    UPDATEUSERINFO_SERVICE_EXCEPTION(1, "用户信息修改失败"),
    UPDATEUSERINFO_SYSTEM_EXCEPTION(999, "系统出现异常，请联系管理员"),
    ;

    UserVoEnum() {
    }

    /**
     * 三个字段在同一时间实际只用两个
     *  即有些请求需要 返回数据 和 状态码 ，例如 用户信息请求
     *  有些请求需要 msg和状态码 例如推出登录
     *
     *  在使用的时候，若需要返回Bean数据，需调用 setData() 方法
     */
    @JSONField(name = "data")
    private Object data = null;
    @JSONField(name = "status")
    private Integer status;
    @JSONField(name = "msg")
    private String msg;

    UserVoEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;

    }

    public Object getData() {
        return data;
    }

    public Object setData(Object data) {
        this.data = data;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 该方法用于在序列化时，正确的将枚举类型转化为JSON
     * @param jsonSerializer
     * @param o
     * @param type
     * @param i
     * @throws IOException
     */

    public void write(JSONSerializer jsonSerializer, Object o, Type type, int i) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", status);
        if (data != null)
            jsonObject.put("data", data);
        else
            jsonObject.put("msg", msg);
        jsonSerializer.write(jsonObject);
    }
}
