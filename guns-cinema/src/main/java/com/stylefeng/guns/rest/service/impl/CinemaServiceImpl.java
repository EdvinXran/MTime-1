package com.stylefeng.guns.rest.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.persistence.dao.*;
import com.stylefeng.guns.rest.persistence.model.*;
import com.stylefeng.guns.rest.service.CinemaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
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
//            for (MtimeBrandDictT mtimeBrandDictT : brandList) {
//                //把99的那个先删除
//                if(mtimeBrandDictT.getUuid()==99){
//                    brandList.remove(mtimeBrandDictT);
//                }
//            }
//            java.util.ConcurrentModificationException: null 迭代的时候不能去修改
            Iterator<MtimeBrandDictT> iterator = brandList.iterator();
            while(iterator.hasNext()){
                MtimeBrandDictT mtimeBrandDictT = iterator.next();
                if(mtimeBrandDictT.getUuid()==99){
                    iterator.remove();
                }
            }
        }else {
            MtimeBrandDictT mtimeBrandDictT = mtimeBrandDictTMapper.selectById(brandId);
            brandList.add(mtimeBrandDictT);
        }

        //整理数据
        List<BrandVO> brandVOS = new ArrayList<>();
        if(brandId==99){
            BrandVO brandVO = new BrandVO();
            brandVO.setIsActive(true);
            brandVO.setBrandId(99);
            brandVO.setBrandName("全部");
            brandVOS.add(brandVO);
        }
        for (MtimeBrandDictT mtimeBrandDictT : brandList) {
            BrandVO brandVO = new BrandVO();
            brandVO.setBrandId(mtimeBrandDictT.getUuid());
            brandVO.setBrandName(mtimeBrandDictT.getShowName());
            brandVO.setIsActive(false);
            brandVOS.add(brandVO);
        }
        return brandVOS;
    }

    @Override
    public List<AreaVO> getAreas(int areaId) {
        List<MtimeAreaDictT> areaList = new ArrayList<>();
        if(areaId==99){
            areaList = mtimeAreaDictTMapper.selectList(null);
            //把99的那个先删除
            Iterator<MtimeAreaDictT> iterator = areaList.iterator();
            while(iterator.hasNext()){
                MtimeAreaDictT mtimeAreaDictT = iterator.next();
                if(mtimeAreaDictT.getUuid()==99){
                    iterator.remove();
                }
            }
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
            //把99的那个先删除
            Iterator<MtimeHallDictT> iterator = hallDictTList.iterator();
            while(iterator.hasNext()){
                MtimeHallDictT mtimeHallDictT = iterator.next();
                if (mtimeHallDictT.getUuid()==99){
                    iterator.remove();
                }
            }
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
//根据影院编号，获取影院信息
    @Override
    public CinemaInfoVO getCinemaInfoById(int cinemaId) {
        MtimeCinemaT mtimeCinemaT = mtimeCinemaTMapper.selectById(cinemaId);
        CinemaInfoVO cinemaInfoVO = new CinemaInfoVO();
        cinemaInfoVO.setCinemaAddress(mtimeCinemaT.getAddress());
        cinemaInfoVO.setImgUrl(mtimeCinemaT.getImgAddress());
        cinemaInfoVO.setCinemaPhone(mtimeCinemaT.getCinemaPhone());
        cinemaInfoVO.setCinemaName(mtimeCinemaT.getCinemaName());
        cinemaInfoVO.setCinemaId(mtimeCinemaT.getUuid()+"");

        return cinemaInfoVO;
    }
//获取所有电影的信息和对应的放映场次信息，根据影院编号
    @Override
    public List<FilmInfoVO> getFilmInfoByCinemaId(int cinemaId) {
        List<FilmInfoVO> filmInfos = mtimeFieldTMapper.getFilmInfos(cinemaId);

        return filmInfos;
    }
//根据放映场次ID获取放映信息
    @Override
    public HallInfoVO getFilmFieldInfo(int fieldId) {

        HallInfoVO hallInfoVO = mtimeFieldTMapper.getHallInfo(fieldId);

        return hallInfoVO;

    }
//根据放映场次查询播放的电影编号，然后根据电影编号获取对应的电影信息
    @Override
    public FilmInfoVO getFilmInfoByFieldId(int fieldId) {

        FilmInfoVO filmInfoVO = mtimeFieldTMapper.getFilmInfoById(fieldId);

        return filmInfoVO;
    }

}
