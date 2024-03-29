package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.FilmInfoVO;
import com.stylefeng.guns.rest.persistence.model.HallInfoVO;
import com.stylefeng.guns.rest.persistence.model.MtimeFieldT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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
}
