package com.stylefeng.guns.rest.modular.cinema.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.modular.cinema.vo.*;

import java.util.List;

/**
 * Created by Gavin
 * on 2019/4/22 17:39
 */
public interface CinemaServiceAPI {

    Page<CinemaVO> getCinemas(CinemaQueryVO cinemaQueryVO);

    List<BrandVO> getBrands(int brandId);

    List<AreaVO> getAreas(int areaId);

    List<HallTypeVO> getHallTypes(int hallType);

    CinemaInfoVO getCinemaInfoById(int cinemaId);

    HallInfoVO getFilmFieldInfo(int fieldId);

    FilmInfoVO getFilmInfoByFieldId(int fieldId);


}