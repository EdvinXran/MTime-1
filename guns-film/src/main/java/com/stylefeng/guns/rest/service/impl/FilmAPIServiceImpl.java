package com.stylefeng.guns.rest.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.model.*;
import com.stylefeng.guns.rest.persistence.dao.*;
import com.stylefeng.guns.rest.persistence.model.*;
import com.stylefeng.guns.rest.service.FilmAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;



@Service(interfaceClass = FilmAPIService.class)
@Component
public class FilmAPIServiceImpl implements FilmAPIService {

    @Autowired
    MtimeBannerTMapper mtimeBannerTMapper;
    @Autowired
    MtimeFilmTMapper mtimeFilmTMapper;
    @Autowired
    MtimeCatDictTMapper mtimeCatDictTMapper;
    @Autowired
    MtimeYearDictTMapper mtimeYearDictTMapper;
    @Autowired
    MtimeSourceDictTMapper mtimeSourceDictTMapper;

    //首页显示横栏
    @Override
    public List<MtimeBanner> selectAllBanner() {
        List<MtimeBannerT> mtimeBannerTS = mtimeBannerTMapper.selectAllBanner();
        List<MtimeBanner> mtimeBanners = new ArrayList<>();
        for (MtimeBannerT bannerT : mtimeBannerTS) {
            MtimeBanner mtimeBanner = new MtimeBanner();
            mtimeBanner.setBannerId(bannerT.getUuid());
            mtimeBanner.setBannerAddress(bannerT.getBannerAddress());
            mtimeBanner.setBannerUrl(bannerT.getBannerUrl());
            //mtimeBanner.setIsValid(bannerT.getIsValid());
            mtimeBanners.add(mtimeBanner);
        }
        return mtimeBanners;
    }

    @Override
    public FilmHomeVo selectHomeFilm() {
        FilmHomeVo filmHomeVo = new FilmHomeVo();
        DataVo dataVo = new DataVo();
        HotFilmsVo hotFilmsVo = new HotFilmsVo();
        SoonFilmVo soonFilmVo = new SoonFilmVo();
       /* FilmAPIServiceImpl filmAPIServiceImpl = new FilmAPIServiceImpl();
        List<MtimeBanner> mtimeBanners = filmAPIServiceImpl.selectAllBanner();
        List<MtimeFilm> hotFilms = filmAPIServiceImpl.selectHomeHotFilms();
        List<MtimeFilm> soonFilms = filmAPIServiceImpl.selectHomeSoonFilms();
        List<MtimeFilm> boxRankingFilms = filmAPIServiceImpl.selectHomeBoxRankingFilms();
        List<MtimeFilm> expectRankingFilms = filmAPIServiceImpl.selectHomeExpectRankingFilms();
        List<MtimeFilm> top100Films = filmAPIServiceImpl.selectHomeTop100Films();*/
        List<MtimeBanner> mtimeBanners =selectAllBanner();
        List<MtimeFilm> hotFilms =selectHomeHotFilms();
        List<MtimeFilm> soonFilms =selectHomeSoonFilms();
        List<MtimeFilm> boxRankingFilms =selectHomeBoxRankingFilms();
        List<MtimeFilm> expectRankingFilms =selectHomeExpectRankingFilms();
        List<MtimeFilm> top100Films =selectHomeTop100Films();
        hotFilmsVo.setFilmInfo(hotFilms);
        hotFilmsVo.setFilmNum(28);
        soonFilmVo.setFilmInfo(soonFilms);
        soonFilmVo.setFilmNum(295);
        dataVo.setBanners(mtimeBanners);
        dataVo.setBoxRanking(boxRankingFilms);
        dataVo.setExpectRanking(expectRankingFilms);
        dataVo.setHotFilms(hotFilmsVo);
        dataVo.setSoonFilms(soonFilmVo);
        dataVo.setTop100(top100Films);
        filmHomeVo.setStatus(0);
        filmHomeVo.setImgPre("http://img.meetingshop.cn/");
        filmHomeVo.setData(dataVo);
        return filmHomeVo;
    }

    //@Override
    public List<MtimeFilm> selectHomeHotFilms() {
        List<MtimeFilmT> hotMtimeFilmTS = mtimeFilmTMapper.selectHomeHotFilms();
        List<MtimeFilm> mtimeBanners = new ArrayList<>();
        for (MtimeFilmT bannerT : hotMtimeFilmTS) {
            MtimeFilm mtimeBanner = new MtimeFilm();
            mtimeBanner.setFilmId(bannerT.getUuid());
            mtimeBanner.setFilmType(bannerT.getFilmType());
            mtimeBanner.setImgAddress(bannerT.getImgAddress());
            mtimeBanner.setFilmName(bannerT.getFilmName());
            mtimeBanner.setFilmScore(bannerT.getFilmScore());
            mtimeBanners.add(mtimeBanner);
        }
        return mtimeBanners;
    }

    //@Override
    public List<MtimeFilm> selectHomeSoonFilms() {
        List<MtimeFilmT> soonMtimeFilmTS = mtimeFilmTMapper.selectHomeSoonFilms();
        List<MtimeFilm> mtimeBanners = new ArrayList<>();
        for (MtimeFilmT bannerT : soonMtimeFilmTS) {
            MtimeFilm mtimeBanner = new MtimeFilm();
            mtimeBanner.setFilmId(bannerT.getUuid());
            mtimeBanner.setFilmType(bannerT.getFilmType());
            mtimeBanner.setImgAddress(bannerT.getImgAddress());
            mtimeBanner.setFilmName(bannerT.getFilmName());
            mtimeBanner.setFilmScore(bannerT.getFilmScore());
            mtimeBanner.setShowTime(bannerT.getFilmTime());
            mtimeBanners.add(mtimeBanner);
        }
        return mtimeBanners;
    }

   // @Override
   /* filmId：’002’,
    imgAddress：‘img/film/002.jpg’
    filmName：‘狄仁杰之四大天王’,
    boxNum：231*/

    public List<MtimeFilm> selectHomeBoxRankingFilms() {
        List<MtimeFilmT> boxRankingFilms = mtimeFilmTMapper.selectHomeBoxRankingFilms();
        List<MtimeFilm> mtimeFilmList = new ArrayList<>();
        for (MtimeFilmT boxRankingFilm : boxRankingFilms) {
            MtimeFilm mtimeFilm = new MtimeFilm();
            mtimeFilm.setFilmId(boxRankingFilm.getUuid());
            mtimeFilm.setImgAddress(boxRankingFilm.getImgAddress());
            mtimeFilm.setFilmName(boxRankingFilm.getFilmName());
            mtimeFilm.setBoxNum(boxRankingFilm.getFilmBoxOffice());
            mtimeFilmList.add(mtimeFilm);
        }
        return mtimeFilmList;
    }

  //  @Override
    /*filmId：’002’,
    imgAddress：‘img/film/002.jpg’
    filmName：‘狄仁杰之四大天王’,
    expectNum：231850*/

    public List<MtimeFilm> selectHomeExpectRankingFilms() {
        List<MtimeFilmT> expectRankingFilms = mtimeFilmTMapper.selectHomeExpectRankingFilms();
        List<MtimeFilm> mtimeFilmList =new ArrayList<>();
        for (MtimeFilmT expectRankingFilm : expectRankingFilms) {
            MtimeFilm mtimeFilm = new MtimeFilm();
            mtimeFilm.setFilmId(expectRankingFilm.getUuid());
            mtimeFilm.setImgAddress(expectRankingFilm.getImgAddress());
            mtimeFilm.setFilmName(expectRankingFilm.getFilmName());
            mtimeFilm.setExpectNum(expectRankingFilm.getFilmPresalenum());
            mtimeFilmList.add(mtimeFilm);
        }
        return mtimeFilmList;
    }

    //@Override
    /*filmId：’002’,
    imgAddress：‘img/film/002.jpg’
    filmName：‘狄仁杰之四大天王’,
    score：’9.3’*/

    public List<MtimeFilm> selectHomeTop100Films() {
        List<MtimeFilmT> top100Films = mtimeFilmTMapper.selectHomeTop100Films();
        List<MtimeFilm> mtimeFilmList = new ArrayList<>();
        for (MtimeFilmT top100Film : top100Films) {
            MtimeFilm mtimeFilm = new MtimeFilm();
            mtimeFilm.setFilmId(top100Film.getUuid());
            mtimeFilm.setImgAddress(top100Film.getImgAddress());
            mtimeFilm.setFilmName(top100Film.getFilmName());
            mtimeFilm.setScore(top100Film.getFilmScore());
            mtimeFilmList.add(mtimeFilm);
        }
        return mtimeFilmList;
    }

    @Override
    public SeachConditionVo selectAllBySeachCondition(SeachCondition seachCondition) {
        SeachDataVo seachDataVo = new SeachDataVo();
        SeachConditionVo seachConditionVo = new SeachConditionVo();
        int catId = seachCondition.getCatId();
        int sourceId = seachCondition.getSourceId();
        int yearId = seachCondition.getYearId();
        if (catId == 0){
            catId =99;
        }
        if (sourceId == 0){
            sourceId=99;
        }
        if (yearId == 0){
            yearId =99;
        }
        List<CatInfo> catInfoList = new ArrayList<>();
        List<MtimeCatDictT> catDictTS = mtimeCatDictTMapper.selectAllMtimeCatDictT();
        for (MtimeCatDictT dictT : catDictTS) {
            CatInfo catInfo = new CatInfo();
            catInfo.setActive(false);
            catInfo.setCatId(dictT.getUuid());
            catInfo.setCatName(dictT.getShowName());
            if (dictT.getUuid() == catId){
                catInfo.setActive(true);
            }
            catInfoList.add(catInfo);
        }

        List<SourceInfo> sourceInfoList = new ArrayList<>();
        List<MtimeSourceDictT> sourceDictTS = mtimeSourceDictTMapper.selectAllMtimeSourceDictT();
        for (MtimeSourceDictT sourceDictT : sourceDictTS) {
            SourceInfo sourceInfo = new SourceInfo();
            sourceInfo.setSourceId(sourceDictT.getUuid());
            sourceInfo.setSourceName(sourceDictT.getShowName());
            sourceInfo.setActive(false);
            if (sourceDictT.getUuid() == sourceId){
                sourceInfo.setActive(true);
            }
            sourceInfoList.add(sourceInfo);
        }

        List<YearInfo> yearInfoList = new ArrayList<>();
        List<MtimeYearDictT> yearDictTS = mtimeYearDictTMapper.selectAllMtimeYearDictT();
        for (MtimeYearDictT yearDictT : yearDictTS) {
            YearInfo yearInfo = new YearInfo();
            yearInfo.setYearId(yearDictT.getUuid());
            yearInfo.setYearName(yearDictT.getShowName());
            yearInfo.setActive(false);
            if (yearDictT.getUuid() == yearId){
                yearInfo.setActive(true);
            }
            yearInfoList.add(yearInfo);
        }
        seachDataVo.setCatInfo(catInfoList);
        seachDataVo.setSourceInfo(sourceInfoList);
        seachDataVo.setYearInfo(yearInfoList);
        seachConditionVo.setStatus(0);
        seachConditionVo.setData(seachDataVo);
        return seachConditionVo;
    }


    //3、影片查询接口
   /* @Override
    public FilmsVo findFilms(FilmsGetVo filmsGetVo) {
        int showType = filmsGetVo.getShowType();
        int sortId = filmsGetVo.getSortId();
        int catId = filmsGetVo.getCatId();
        int sourceId = filmsGetVo.getSourceId();
        int yearId = filmsGetVo.getYearId();
        int nowPage = filmsGetVo.getNowPage();
        filmsGetVo
        if (showType == 0){
            showType =1;
        }

        //======================================
        if (showType == 1 ){
            if (sortId == 1){

            }
        }
        return null;
    }*/
}
