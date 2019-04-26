package com.stylefeng.guns.rest.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.persistence.model.Actors;
import com.stylefeng.guns.rest.persistence.model.OrderVO;

/**
 * Created by Gavin
 * on 2019/4/25 10:22
 */
public interface OrderServiceAPI {
    // 验证售出的票是否为真
    boolean isTrueSeats(String fieldId, String seats) throws Exception;

    // 已经销售的座位里，有没有这些座位
    boolean isNotSoldSeats(String fieldId, String seats) throws Exception;

    // 创建订单信息
    OrderVO saveOrderInfo(Integer fieldId, String soldSeats, String seatsName, Integer userId) throws Exception;

    // 使用当前登陆人获取已经购买的订单
    Page<OrderVO> getOrderByUserId(Integer userId, Page<OrderVO> page) throws Exception;

    // 根据FieldId 获取所有已经销售的座位编号
    String getSoldSeatsByFieldId(Integer fieldId) throws Exception;

    // 根据订单编号获取订单信息
    OrderVO getOrderInfoById(String orderId) throws Exception;

    // 支付成功
    void paySuccess(int orderId);
    // 支付失败
    void payFailed(int orderId);
}
