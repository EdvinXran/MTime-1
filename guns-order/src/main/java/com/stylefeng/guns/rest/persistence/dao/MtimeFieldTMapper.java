package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.FieldInfo;
import com.stylefeng.guns.rest.persistence.model.FilmInfoVO;
import com.stylefeng.guns.rest.persistence.model.HallInfoVO;
import com.stylefeng.guns.rest.persistence.model.MtimeFieldT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 放映场次表 Mapper 接口
 * </p>
 *
 * @author Gavin
 * @since 2019-04-23
 */
@Mapper
public interface MtimeFieldTMapper extends BaseMapper<MtimeFieldT> {

    List<FilmInfoVO> getFilmInfos(int cinemaId);

    HallInfoVO getHallInfo(int fieldId);

    FilmInfoVO getFilmInfoById(int fieldId);

    FieldInfo getFieldInfoById(int fieldId);

    @Select("select film_name from mtime_film_t where UUID = #{filmId}")
    public String getFilmNameById(Integer filmId) throws Exception;
}
