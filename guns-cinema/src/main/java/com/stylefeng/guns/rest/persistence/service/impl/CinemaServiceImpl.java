package com.stylefeng.guns.rest.persistence.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.persistence.dao.MtimeCinemaTMapper;
import com.stylefeng.guns.rest.persistence.model.CinemaQueryVO;
import com.stylefeng.guns.rest.persistence.model.MtimeCinemaT;
import com.stylefeng.guns.rest.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Gavin
 * on 2019/4/22 17:14
 */
@Component
@Service(interfaceClass = CinemaService.class)
public class CinemaServiceImpl implements CinemaService{

    @Autowired
    MtimeCinemaTMapper mtimeCinemaTMapper;

    @Override
    public CinemaQueryVO queryCinemasByConditions(String brandId, String hallType, String districtId) {
        CinemaQueryVO cinemaQueryVO = new CinemaQueryVO();
        List<MtimeCinemaT> cinemas =  mtimeCinemaTMapper.selectCinemasByBrandAndHallTypeAndDistrictId(brandId, hallType, districtId);
        if(cinemas.size()!=0){
            cinemaQueryVO.setStatus(0);
            cinemaQueryVO.setNowPage(1);
            cinemaQueryVO.setTotalPage(5);
            HashMap<String, Object> map = new HashMap<>();
            map.put("cinemas",cinemas);
            cinemaQueryVO.setData(map);
        }else {
            cinemaQueryVO.setStatus(1);
            cinemaQueryVO.setMsg("影院信息查询失败");
        }
        return cinemaQueryVO;

    }
}
