package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.model.FilmsGetVo;
import com.stylefeng.guns.rest.persistence.model.MtimeFilmT;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author liang
 * @since 2019-04-21
 */
public interface MtimeFilmTMapper extends BaseMapper<MtimeFilmT> {

    List<MtimeFilmT> selectHomeHotFilms();

    List<MtimeFilmT> selectHomeSoonFilms();

    List<MtimeFilmT> selectHomeBoxRankingFilms();

    List<MtimeFilmT> selectHomeExpectRankingFilms();

    List<MtimeFilmT> selectHomeTop100Films();

    List<MtimeFilmT> findFilms(FilmsGetVo filmsGetVo);
}
