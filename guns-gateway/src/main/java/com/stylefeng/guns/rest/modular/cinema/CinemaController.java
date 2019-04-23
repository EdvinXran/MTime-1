package com.stylefeng.guns.rest.modular.cinema;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.modular.cinema.vo.*;
import com.stylefeng.guns.rest.modular.cinema.service.CinemaServiceAPI;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Gavin
 * on 2019/4/22 17:18
 */
@RestController
@RequestMapping("/cinema")
public class CinemaController {
    @Reference
    CinemaServiceAPI cinemaService;

    @RequestMapping(value = "/getCinemas" ,method = RequestMethod.GET)
    public String getCinemas( CinemaQueryVO cinemaQueryVO) {
        HashMap<String, Object> responseMap = new HashMap<>();

        //参数校验
        if(cinemaQueryVO==null){
            responseMap.put("status",1);
            responseMap.put("msg","影院信息获取失败");
            return JSONObject.toJSONString(responseMap);
        }
        if(cinemaQueryVO.getBrandId()==0){
            cinemaQueryVO.setBrandId(99);
        }
        if(cinemaQueryVO.getDistrictId()==0){
            cinemaQueryVO.setDistrictId(99);
        }
        if(cinemaQueryVO.getHallType()==0){
            cinemaQueryVO.setHallType(99);
        }
        if(cinemaQueryVO.getNowPage()==0){
            cinemaQueryVO.setNowPage(1);
        }
        if(cinemaQueryVO.getPageSize()==0){
            cinemaQueryVO.setPageSize(12);
        }
        //调用Service
        Page<CinemaVO> page = cinemaService.getCinemas(cinemaQueryVO);
        List<CinemaVO> records = page.getRecords();
        responseMap.put("cinemas",records);
        //整理数据
        CinemaQueryResponseVO cinemaQueryResponseVO = new CinemaQueryResponseVO();
        cinemaQueryResponseVO.setStatus(0);
        cinemaQueryResponseVO.setNowPage(page.getCurrent());
        cinemaQueryResponseVO.setTotalPage((int)(page.getPages()));
        cinemaQueryResponseVO.setData(responseMap);
        return JSONObject.toJSONString(cinemaQueryResponseVO);
    }
    @RequestMapping(value = "/getCondition",method = RequestMethod.GET)
    public String getConditions(CinemaConditionVO cinemaConditionVO){
        HashMap<String, Object> responseMap = new HashMap<>();
        //先对前端传来的东西进行合法校验
        if(cinemaConditionVO==null){
            responseMap.put("status",1);
            responseMap.put("msg","影院信息查询失败");
            return JSONObject.toJSONString(responseMap);
        }
        if(cinemaConditionVO.getBrandId()==0){
            cinemaConditionVO.setBrandId(99);
        }
        if(cinemaConditionVO.getDistrictId()==0){
            cinemaConditionVO.setDistrictId(99);
        }
        if(cinemaConditionVO.getHallType()==0){
            cinemaConditionVO.setHallType(99);
        }
        //调用Service查询
        List<BrandVO> brands = cinemaService.getBrands(cinemaConditionVO.getBrandId());
        List<AreaVO> areas = cinemaService.getAreas(cinemaConditionVO.getDistrictId());
        List<HallTypeVO> hallTypes = cinemaService.getHallTypes(cinemaConditionVO.getHallType());

       //整理数据
        responseMap.put("brands",brands);
        responseMap.put("areas",areas);
        responseMap.put("hallTypes",hallTypes);
        CinemaConditionResponseVO cinemaConditionResponseVO = new CinemaConditionResponseVO();
        cinemaConditionResponseVO.setData(responseMap);
        return JSONObject.toJSONString(cinemaConditionResponseVO);
    }
}
