package com.stylefeng.guns.rest.modular.cinema;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.vo.CinemaRequestVO;
import com.stylefeng.guns.rest.persistence.model.CinemaQueryVO;
import com.stylefeng.guns.rest.service.CinemaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Gavin
 * on 2019/4/22 17:18
 */
@RestController
@RequestMapping("/cinema")
public class CinemaController {
    @Reference
    CinemaService cinemaService;

    @RequestMapping("/getCinemas")
    public CinemaQueryVO getCinemas(CinemaRequestVO cinemaRequestVO) {
        CinemaQueryVO cinemaQueryVO = cinemaService.queryCinemasByConditions(cinemaRequestVO.getBrandId(), cinemaRequestVO.getHallType(),cinemaRequestVO.getDistrictId() );
        return cinemaQueryVO;
    }
}
