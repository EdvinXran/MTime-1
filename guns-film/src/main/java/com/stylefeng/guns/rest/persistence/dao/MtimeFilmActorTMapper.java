package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.Actors;
import com.stylefeng.guns.rest.persistence.model.MtimeFilmActorT;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 影片与演员映射表 Mapper 接口
 * </p>
 *
 * @author liang
 * @since 2019-04-21
 */
public interface MtimeFilmActorTMapper extends BaseMapper<MtimeFilmActorT> {

    List<MtimeFilmActorT> selectListById(int searchType);
}
