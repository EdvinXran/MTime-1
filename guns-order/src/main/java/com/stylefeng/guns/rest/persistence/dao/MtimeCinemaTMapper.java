package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.MtimeCinemaT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 影院信息表 Mapper 接口
 * </p>
 *
 * @author Gavin
 * @since 2019-04-21
 */
@Mapper
public interface MtimeCinemaTMapper extends BaseMapper<MtimeCinemaT> {

    List<MtimeCinemaT> selectCinemasByBrandAndHallTypeAndDistrictId(@Param("brandId") String brandId, @Param("hallType") String hallType, @Param("districtId") String districtId);

    @Select("select show_name from mtime_brand_dict_t where UUID = #{cinemaId}")
    String selectCinemaNameById(Integer cinemaId) throws Exception;
}
