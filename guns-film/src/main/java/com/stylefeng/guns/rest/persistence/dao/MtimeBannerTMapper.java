package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.MtimeBannerT;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * banner信息表 Mapper 接口
 * </p>
 *
 * @author liang
 * @since 2019-04-21
 */
public interface MtimeBannerTMapper{

    List<MtimeBannerT> selectAllBanner();
}
