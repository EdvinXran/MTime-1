package com.stylefeng.guns.rest.service;


import com.stylefeng.guns.rest.persistence.model.*;

import java.util.List;

/**
 * <p>
 * banner信息表 服务类
 * </p>
 *
 * @author liang
 * @since 2019-04-21
 */
public interface FilmAPIService {

    List<MtimeBanner> selectAllBanner();

    FilmHomeVo selectHomeFilm();

    SeachConditionVo selectAllBySeachCondition(SeachCondition seachCondition);

    //FilmsVo findFilms(FilmsGetVo filmsGetVo);

    /*List<MtimeFilm> selectHomeHotFilms();

    List<MtimeFilm> selectHomeSoonFilms();

    List<MtimeFilm> selectHomeBoxRankingFilms();

    List<MtimeFilm> selectHomeExpectRankingFilms();

    List<MtimeFilm> selectHomeTop100Films();*/
}
