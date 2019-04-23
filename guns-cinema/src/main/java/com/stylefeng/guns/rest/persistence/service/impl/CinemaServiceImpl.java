package com.stylefeng.guns.rest.persistence.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.modular.cinema.vo.*;
import com.stylefeng.guns.rest.persistence.dao.*;
import com.stylefeng.guns.rest.persistence.model.*;
import com.stylefeng.guns.rest.modular.cinema.service.CinemaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gavin
 * on 2019/4/22 17:14
 */
@Component
@Service(interfaceClass = CinemaServiceAPI.class)
public class CinemaServiceImpl implements CinemaServiceAPI{

    @Autowired
    MtimeCinemaTMapper mtimeCinemaTMapper;

    @Autowired
    MtimeBrandDictTMapper mtimeBrandDictTMapper;

    @Autowired
    MtimeHallDictTMapper mtimeHallDictTMapper;

    @Autowired
    MtimeFieldTMapper mtimeFieldTMapper;

    @Autowired
    MtimeHallFilmInfoTMapper mtimeHallFilmInfoTMapper;

    @Autowired
    MtimeAreaDictTMapper mtimeAreaDictTMapper;


    @Override
    public Page<CinemaVO> getCinemas(CinemaQueryVO cinemaQueryVO) {
        Page<MtimeCinemaT> page = new Page<>(cinemaQueryVO.getNowPage(),cinemaQueryVO.getPageSize());
        List<CinemaVO> cinemaVOList = new ArrayList<>();
        EntityWrapper<MtimeCinemaT> entityWrapper = new EntityWrapper<>();
        if(cinemaQueryVO.getBrandId() != 99){
            entityWrapper.eq("brand_id",cinemaQueryVO.getBrandId());
        }
        if(cinemaQueryVO.getDistrictId() != 99){
            entityWrapper.eq("area_id",cinemaQueryVO.getDistrictId());
        }
        if(cinemaQueryVO.getHallType() != 99){
            entityWrapper.like("hall_ids",cinemaQueryVO.getHallType()+"");
        }
        List<MtimeCinemaT> cinemaList = mtimeCinemaTMapper.selectPage(page, entityWrapper);
        for (MtimeCinemaT mtimeCinemaT : cinemaList) {
            CinemaVO cinemaVO = new CinemaVO();
            cinemaVO.setUuid(mtimeCinemaT.getUuid());
            cinemaVO.setCinemaName(mtimeCinemaT.getCinemaName());
            cinemaVO.setMinimumPrice(mtimeCinemaT.getMinimumPrice());
            cinemaVO.setAddress(mtimeCinemaT.getAddress());
            cinemaVOList.add(cinemaVO);
        }

        // 查询多少个记录
        Integer count = mtimeCinemaTMapper.selectCount(entityWrapper);

        //整理数据
        Page<CinemaVO> cinemaVOPage = new Page<>();
        cinemaVOPage.setTotal(count);
        cinemaVOPage.setRecords(cinemaVOList);
        cinemaVOPage.setSize(cinemaQueryVO.getPageSize());
        return cinemaVOPage;
    }

    @Override
    public List<BrandVO> getBrands(int brandId) {
        List<MtimeBrandDictT> brandList = new ArrayList<>();
        if(brandId==99){
            //当条件为null时 代表select *
             brandList = mtimeBrandDictTMapper.selectList(null);
        }else {
            MtimeBrandDictT mtimeBrandDictT = mtimeBrandDictTMapper.selectById(brandId);
            brandList.add(mtimeBrandDictT);
        }

        //整理数据
        List<BrandVO> brandVOS = new ArrayList<>();
        if(brandId==99){
            BrandVO brandVO = new BrandVO();
            brandVO.setActive(true);
            brandVO.setBrandId(99);
            brandVO.setBrandName("全部");
            brandVOS.add(brandVO);
        }
        for (MtimeBrandDictT mtimeBrandDictT : brandList) {
            BrandVO brandVO = new BrandVO();
            brandVO.setBrandId(mtimeBrandDictT.getUuid());
            brandVO.setBrandName(mtimeBrandDictT.getShowName());
            brandVO.setActive(false);
            brandVOS.add(brandVO);
        }
        return brandVOS;
    }

    @Override
    public List<AreaVO> getAreas(int areaId) {
        List<MtimeAreaDictT> areaList = new ArrayList<>();
        if(areaId==99){
            areaList = mtimeAreaDictTMapper.selectList(null);
        }else {
            MtimeAreaDictT mtimeAreaDictT = mtimeAreaDictTMapper.selectById(areaId);
            areaList.add(mtimeAreaDictT);
        }


        //整理数据
        List<AreaVO> areaVOS = new ArrayList<>();
        //当99的时候 要处理这种特殊情况
        if(areaId == 99){
            AreaVO areaVO = new AreaVO(99, "全部", true);
            areaVOS.add(areaVO);
        }
        for (MtimeAreaDictT mtimeAreaDictT : areaList) {
            AreaVO areaVO = new AreaVO(mtimeAreaDictT.getUuid(), mtimeAreaDictT.getShowName(), false);
            areaVOS.add(areaVO);
        }
        return areaVOS;
    }

    @Override
    public List<HallTypeVO> getHallTypes(int hallType) {
        List<MtimeHallDictT> hallDictTList = new ArrayList<>();
        if(hallType==99){
            hallDictTList = mtimeHallDictTMapper.selectList(null);
        }else {
            MtimeHallDictT mtimeHallDictT = mtimeHallDictTMapper.selectById(hallType);
            hallDictTList.add(mtimeHallDictT);
        }


        //整理数据
        List<HallTypeVO> hallTypeVOS = new ArrayList<>();
        //当99的时候 要处理这种特殊情况
        if(hallType == 99){
            HallTypeVO hallTypeVO = new HallTypeVO(99, "全部", true);
            hallTypeVOS.add(hallTypeVO);
        }
        for (MtimeHallDictT mtimeHallDictT : hallDictTList) {
            HallTypeVO hallTypeVO = new HallTypeVO(mtimeHallDictT.getUuid(), mtimeHallDictT.getShowName(), false);
            hallTypeVOS.add(hallTypeVO);
        }
        return hallTypeVOS;
    }

    @Override
    public CinemaInfoVO getCinemaInfoById(int cinemaId) {
        return null;
    }

    @Override
    public HallInfoVO getFilmFieldInfo(int fieldId) {
        return null;
    }

    @Override
    public FilmInfoVO getFilmInfoByFieldId(int fieldId) {
        return null;
    }
}
