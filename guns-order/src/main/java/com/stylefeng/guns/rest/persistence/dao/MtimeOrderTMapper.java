package com.stylefeng.guns.rest.persistence.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.persistence.model.MtimeOrderT;
import com.stylefeng.guns.rest.persistence.model.OrderInsertVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface MtimeOrderTMapper extends BaseMapper<MtimeOrderT> {

    public String getSoldSeatsByFieldId(@Param("fieldId")Integer fieldId);

    String getSeatsByFiledId(@Param("filedId") String filedId);

    @Insert("insert into mtime_order_t values(#{orderId},#{cinemaId},#{fieldId},#{filmId},#{seatsIds},#{seatsName},#{filmPrice},#{orderPrice},#{orderTime},#{orderUserId},#{orderStatus})")
    public int saveOrderInfo(OrderInsertVo orderInsertVo) throws Exception;
}
