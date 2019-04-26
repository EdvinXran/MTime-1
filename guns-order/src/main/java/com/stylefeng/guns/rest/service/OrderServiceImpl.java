package com.stylefeng.guns.rest.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.persistence.dao.MtimeCinemaTMapper;
import com.stylefeng.guns.rest.persistence.dao.MtimeFieldTMapper;
import com.stylefeng.guns.rest.persistence.dao.MtimeHallFilmInfoTMapper;
import com.stylefeng.guns.rest.persistence.dao.MtimeOrderTMapper;
import com.stylefeng.guns.rest.persistence.model.*;
import com.stylefeng.guns.rest.util.ReadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    public boolean isTrueSeats(String fieldId, String seats) throws Exception{
        //订单里的位置信息
        String seatPath = mtimeOrderTMapper.getSeatsByFiledId(fieldId);
        //影厅的位置信息
        String readFile = ReadUtil.readFile(seatPath);
        JSONObject jsonObject = JSONObject.parseObject(readFile);
        String ids = jsonObject.get("ids").toString();

        String[] seatArrs = seats.split(",");
        String[] idArrs = ids.split(",");
        int num = 0;
        //匹配上一次，num+1
        for (String id : idArrs) {
            for (String seat : seatArrs) {
                if (seat.equals(id)) {
                    num++;
                }
            }
        }
        // 如果匹配上的数量与已售座位数一致，则表示全都匹配上了
        if (seatArrs.length == num) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isNotSoldSeats(String fieldId, String seats) throws Exception{
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("filed_id", fieldId);

        List<MtimeOrderT> list = mtimeOrderTMapper.selectList(entityWrapper);
        String[] seatsArr = seats.split(",");
        for (MtimeOrderT mtimeOrderT : list) {
            String[] ids = mtimeOrderT.getSeatsIds().split(",");
            for (String id : ids) {
                for (String s : seatsArr) {
                    if(id.equals(s)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public OrderVO saveOrderInfo(Integer fieldId, String soldSeats, String seatsName, Integer userId) throws Exception{
        FieldInfo fieldInfoById = mtimeFieldTMapper.getFieldInfoById(fieldId);
        OrderInsertVo orderInsertVo = new OrderInsertVo();
        String orderId = UUID.randomUUID().toString();
        orderInsertVo.setOrderId(orderId);
        orderInsertVo.setCinemaId(fieldInfoById.getCinemaId());
        orderInsertVo.setFieldId(fieldId);
        orderInsertVo.setFilmId(fieldInfoById.getFilmId());
        orderInsertVo.setSeatsIds(soldSeats);
        orderInsertVo.setSeatsName(seatsName);
        orderInsertVo.setFilmPrice(fieldInfoById.getPrice());
        String[] split = soldSeats.split(",");
        orderInsertVo.setOrderPrice(split.length * fieldInfoById.getPrice());
        Date orderTime = new Date();
        orderInsertVo.setOrderTime(orderTime);
        orderInsertVo.setOrderUserId(userId);
        orderInsertVo.setOrderStatus(0);
        int insertRet = mtimeOrderTMapper.saveOrderInfo(orderInsertVo);
        String cinemaNameById = mtimeCinemaTMapper.selectCinemaNameById(fieldInfoById.getCinemaId());
        String filmNameById = mtimeFieldTMapper.getFilmNameById(fieldInfoById.getFilmId());
        if(insertRet == 1) {
            OrderVO orderVO = new OrderVO();
            orderVO.setOrderId(orderId);
            orderVO.setFilmName(filmNameById);
            orderVO.setFieldTime(fieldInfoById.getBeginTime().toString());
            orderVO.setCinemaName(cinemaNameById);
            orderVO.setSeatsName(seatsName);
            orderVO.setOrderPrice(Integer.toString(split.length * fieldInfoById.getPrice()));
            orderVO.setOrderTimestamp(orderTime.toString());
            orderVO.setOrderStatus(Integer.toString(0));
            return orderVO;
        }else {
            return null;
        }
    }

    // order_status  0是未支付 1是已支付 2是已关闭
    @Override
    public Page<OrderVO> getOrderByUserId(Integer userId, Page<OrderVO> page) throws Exception{
        Page<OrderVO> voPage = new Page<>(page.getCurrent(),page.getSize());
        ArrayList<OrderVO> list = new ArrayList<>();
        EntityWrapper<MtimeOrderT> wrapper = new EntityWrapper<>();
        wrapper.eq("user_id",userId);
        wrapper.eq("order_status",1);
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
    public String getSoldSeatsByFieldId(Integer fieldId) throws Exception{
        String soldSeatsByFieldId = mtimeOrderTMapper.getSoldSeatsByFieldId(fieldId);
        return soldSeatsByFieldId;
    }

    @Override
    public OrderVO getOrderInfoById(String orderId) throws Exception{
        MtimeOrderT mtimeOrderT = mtimeOrderTMapper.selectById(orderId);
        //查找其他参数
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
        return orderVO;
    }



}
