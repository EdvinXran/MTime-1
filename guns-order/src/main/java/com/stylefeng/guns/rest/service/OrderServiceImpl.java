package com.stylefeng.guns.rest.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.modular.order.vo.OrderVO;

/**
 * Created by Gavin
 * on 2019/4/25 10:41
 */
public class OrderServiceImpl implements OrderServiceAPI {

    @Override
    public boolean isTrueSeats(String fieldId, String seats) {
        return false;
    }

    @Override
    public boolean isNotSoldSeats(String fieldId, String seats) {
        return false;
    }

    @Override
    public OrderVO saveOrderInfo(Integer fieldId, String soldSeats, String seatsName, Integer userId) {
        return null;
    }

    @Override
    public Page<OrderVO> getOrderByUserId(Integer userId, Page<OrderVO> page) {
        return null;
    }

    @Override
    public String getSoldSeatsByFieldId(Integer fieldId) {
        return null;
    }

    @Override
    public OrderVO getOrderInfoById(String orderId) {
        return null;
    }
}
