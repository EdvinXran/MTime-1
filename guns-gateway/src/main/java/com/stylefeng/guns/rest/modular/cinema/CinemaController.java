package com.stylefeng.guns.rest.modular.cinema;

import com.stylefeng.guns.rest.persistence.model.CinemaQueryVO;
import com.stylefeng.guns.rest.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Gavin
 * on 2019/4/22 17:18
 */
@RestController
@RequestMapping("/cinema")
public class CinemaController {
    @Autowired
    CinemaService cinemaService;

    @RequestMapping("/getCinemas")
    public CinemaQueryVO getCinemas(String brandId, String hallType, String districtId) {
        CinemaQueryVO cinemaQueryVO = cinemaService.queryCinemasByConditions(brandId, hallType, districtId);
        return cinemaQueryVO;
    }
}
