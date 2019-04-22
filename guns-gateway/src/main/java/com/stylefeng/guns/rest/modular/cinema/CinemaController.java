package com.stylefeng.guns.rest.modular.cinema;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.stylefeng.guns.rest.modular.vo.CinemaRequestVO;
import com.stylefeng.guns.rest.persistence.model.CinemaQueryVO;
import com.stylefeng.guns.rest.service.CinemaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by Gavin
 * on 2019/4/22 17:18
 */
@RestController
@RequestMapping("/cinema")
public class CinemaController {
    @Reference
    CinemaService cinemaService;

    @RequestMapping(value = "/getCinemas" ,method = RequestMethod.GET)
    public String getCinemas( CinemaRequestVO cinemaRequestVO) {


        CinemaQueryVO cinemaQueryVO = cinemaService.queryCinemasByConditions(cinemaRequestVO.getBrandId(), cinemaRequestVO.getHallType(),cinemaRequestVO.getDistrictId() );
        if(cinemaQueryVO!=null){
           return JSONObject.toJSONString(cinemaQueryVO);
        }else {
            HashMap<String, Object> map = new HashMap<>();
            map.put("status",1);
            map.put("msg","影院信息查询失败");
            return JSONObject.toJSONString(map);
        }
    }
}
