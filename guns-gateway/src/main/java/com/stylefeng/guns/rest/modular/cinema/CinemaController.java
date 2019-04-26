package com.stylefeng.guns.rest.modular.cinema;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.persistence.model.*;
import com.stylefeng.guns.rest.service.CinemaServiceAPI;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;



@RestController
@RequestMapping("/cinema")
public class CinemaController {
    @Reference
    CinemaServiceAPI cinemaService;

    @RequestMapping(value = "/getCinemas" ,method = RequestMethod.GET)
    public HashMap<String,Object> getCinemas( CinemaQueryVO cinemaQueryVO) {
        HashMap<String, Object> responseMap = new HashMap<>();

        //参数校验
        if(cinemaQueryVO==null){
            responseMap.put("status",1);
            responseMap.put("msg","影院信息获取失败");
            return responseMap;
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
        HashMap<String, Object> result = new HashMap<>();
        result.put("status",0);
        result.put("nowPage",page.getCurrent());
        result.put("totalPage",page.getPages());
        result.put("data",responseMap);
        return result;
    }
    @RequestMapping(value = "/getCondition",method = RequestMethod.GET)
    public HashMap<String,Object> getConditions(CinemaConditionVO cinemaConditionVO){
        HashMap<String, Object> responseMap = new HashMap<>();
        //先对前端传来的东西进行合法校验
        if(cinemaConditionVO==null){
            responseMap.put("status",1);
            responseMap.put("msg","影院信息查询失败");
            return responseMap;
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
        responseMap.put("brandList",brands);
        responseMap.put("areaList",areas);
        responseMap.put("halltypeList",hallTypes);
/*        CinemaConditionResponseVO cinemaConditionResponseVO = new CinemaConditionResponseVO();
        cinemaConditionResponseVO.setData(responseMap);*/
        HashMap cinemaConditionResponseVO = new HashMap();
        cinemaConditionResponseVO.put("data",responseMap);
        cinemaConditionResponseVO.put("status",0);
        return cinemaConditionResponseVO;
    }

    @RequestMapping(value = "/getFields",method = RequestMethod.GET)
    public CinemaConditionVO getFields(Integer cinemaId){


            CinemaInfoVO cinemaInfoById = cinemaService.getCinemaInfoById(cinemaId);
            List<FilmInfoVO> filmInfoByCinemaId = cinemaService.getFilmInfoByCinemaId(cinemaId);

            CinemaConditionVO cinemaConditionVO = new CinemaConditionVO();
            cinemaConditionVO.setCinemaInfo(cinemaInfoById);
            cinemaConditionVO.setFilmList(filmInfoByCinemaId);
            return cinemaConditionVO;


    }
    @RequestMapping(value = "/getFieldInfo",method = RequestMethod.POST)
    public CinemaQueryVO getFieldInfo(Integer cinemaId, Integer fieldId) {

        CinemaInfoVO cinemaInfoById = cinemaService.getCinemaInfoById(cinemaId);
        FilmInfoVO filmInfoByFieldId = cinemaService.getFilmInfoByFieldId(fieldId);
        HallInfoVO filmFieldInfo = cinemaService.getFilmFieldInfo(fieldId);
        filmFieldInfo.setSoldSeats("1");

        CinemaQueryVO cinemaQueryVO = new CinemaQueryVO();
        cinemaQueryVO.setCinemaInfo(cinemaInfoById);
        cinemaQueryVO.setFilmInfo(filmInfoByFieldId);
        cinemaQueryVO.setHallInfo(filmFieldInfo);
        return cinemaQueryVO;
    }
    }
