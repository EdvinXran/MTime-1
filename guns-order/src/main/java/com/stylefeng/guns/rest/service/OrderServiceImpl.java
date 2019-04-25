package com.stylefeng.guns.rest.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.modular.order.vo.OrderVO;
import com.stylefeng.guns.rest.persistence.dao.MtimeCinemaTMapper;
import com.stylefeng.guns.rest.persistence.dao.MtimeFieldTMapper;
import com.stylefeng.guns.rest.persistence.dao.MtimeHallFilmInfoTMapper;
import com.stylefeng.guns.rest.persistence.dao.MtimeOrderTMapper;
import com.stylefeng.guns.rest.persistence.model.MtimeCinemaT;
import com.stylefeng.guns.rest.persistence.model.MtimeFieldT;
import com.stylefeng.guns.rest.persistence.model.MtimeHallFilmInfoT;
import com.stylefeng.guns.rest.persistence.model.MtimeOrderT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gavin
 * on 2019/4/25 10:41
 */
@Component
@Service(interfaceClass = OrderServiceAPI.class)
public class OrderServiceImpl implements OrderServiceAPI {

    @Autowired
    MtimeOrderTMapper mtimeOrderTMapper;
    @Autowired
    MtimeHallFilmInfoTMapper mtimeHallFilmInfoTMapper;
    @Autowired
    MtimeFieldTMapper mtimeFieldTMapper;
    @Autowired
    MtimeCinemaTMapper mtimeCinemaTMapper;


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
        Page<OrderVO> voPage = new Page<>(page.getCurrent(),page.getSize());
        ArrayList<OrderVO> list = new ArrayList<>();
        EntityWrapper<MtimeOrderT> wrapper = new EntityWrapper<>();
        wrapper.eq("user_id",userId);
        List<MtimeOrderT> mtimeOrderTS = mtimeOrderTMapper.selectPage(voPage, wrapper);
        for (MtimeOrderT mtimeOrderT : mtimeOrderTS) {
            Integer filmId = mtimeOrderT.getFilmId();
            Integer cinemaId = mtimeOrderT.getCinemaId();
            MtimeHallFilmInfoT filmInfo = mtimeHallFilmInfoTMapper.selectById(filmId);
            MtimeCinemaT mtimeCinemaT = mtimeCinemaTMapper.selectById(cinemaId);
            EntityWrapper<MtimeFieldT> fieldTEntityWrapper = new EntityWrapper<>();
            fieldTEntityWrapper.eq("film_id",filmId);
            fieldTEntityWrapper.eq("cinema_id",cinemaId);
            List<MtimeFieldT> mtimeFieldTS = mtimeFieldTMapper.selectList(fieldTEntityWrapper);
            MtimeFieldT mtimeFieldT = mtimeFieldTS.get(0);
            OrderVO orderVO = new OrderVO(mtimeOrderT.getUuid(), filmInfo.getFilmName(), "今天," + mtimeFieldT.getBeginTime(), mtimeCinemaT.getCinemaName(), mtimeOrderT.getSeatsName(), mtimeOrderT.getOrderPrice() + "", mtimeOrderT.getOrderTime() + "", mtimeOrderT.getOrderStatus() + "");
            list.add(orderVO);
        }
        voPage.setRecords(list);
        return voPage;
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
