package com.stylefeng.guns.rest.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.persistence.model.*;
import com.stylefeng.guns.rest.persistence.dao.*;
import com.stylefeng.guns.rest.persistence.model.*;
import com.stylefeng.guns.rest.service.FilmAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


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
    @Autowired
    MtimeFilmInfoTMapper mtimeFilmInfoTMapper;
    @Autowired
    MtimeActorTMapper mtimeActorTMapper;
    @Autowired
    MtimeFilmActorTMapper mtimeFilmActorTMapper;
    
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
    @Override
    public FilmsVo findFilms(FilmsGetVo filmsGetVo) {
        int showType = filmsGetVo.getShowType();
        int sortId = filmsGetVo.getSortId();
        int catId = filmsGetVo.getCatId();
        int sourceId = filmsGetVo.getSourceId();
        int yearId = filmsGetVo.getYearId();
        int nowPage = filmsGetVo.getNowPage();
        int pageSize = filmsGetVo.getPageSizel();
        FilmsVo filmsVo = new FilmsVo();
        if (showType == 0){
            showType =1;
        }if (sortId == 0){
            sortId =1;
        }if (catId == 0){
            catId = 99;
        }if (sourceId == 0){
            sourceId = 99;
        }if (yearId == 0){
            yearId = 99;
        }if (nowPage == 0){
            nowPage = 1;
        }if (pageSize == 0){
            pageSize = 18;
        }

        //======================================
        List<FilmVo> mtimeFilmList = null;
       // if (showType == 1 ){
            if (sortId == 1){
                mtimeFilmList =  mtimeFilmTMapper.selectHotFilmByShowType(showType,((nowPage -1)*pageSize),pageSize);
            }
            if (sortId == 2){
                mtimeFilmList =  mtimeFilmTMapper.selectHotFilmByTime(showType,((nowPage -1)*pageSize),pageSize);
            }
            if (sortId == 3){
                mtimeFilmList =  mtimeFilmTMapper.selectHotFilmByScore(showType,((nowPage -1)*pageSize),pageSize);
            }
      //  }

        if (catId != 99){
            for (FilmVo mtimeFilm : mtimeFilmList) {
                String[] split = mtimeFilm.getFilmCats().split("#");
                int fale = 0;
                for (String s : split) {
                    if (!"".equals(s)) {
                        if (catId == Integer.parseInt(s)) {
                            fale = 1;
                        }
                    }
                }
                if (fale == 0){
                    mtimeFilmList.remove(mtimeFilm);
                    break;
                }
            }
        }
        if (sourceId != 99){
            for (FilmVo mtimeFilm : mtimeFilmList) {
                if(sourceId != mtimeFilm.getFilmArea()){
                    mtimeFilmList.remove(mtimeFilm);
                    break;
                }
            }
        }
        if (yearId != 99){
            for (FilmVo mtimeFilm : mtimeFilmList) {
                if(yearId != mtimeFilm.getFilmDate()){
                    mtimeFilmList.remove(mtimeFilm);
                    break;
                }
            }
        }

        filmsVo.setStatus(0);
        filmsVo.setNowPage(nowPage);
        filmsVo.setData(mtimeFilmList);
        filmsVo.setTotalPage(mtimeFilmList.size());
        filmsVo.setImgPre("http://img.meetingshop.cn/");
        return filmsVo;
    }
   //4、影片详情查询接口

    @Override
    public FilmInformationVo selsctFilmInformationVo(int searchType,String searchNameOrId) {
        FilmInformationVo filmInformationVo = new FilmInformationVo();
        DataFilmInformationVo dataFilmInformationVo = new DataFilmInformationVo();
        ActorDirector actorDirector = new ActorDirector();
        Director directorVo = new Director();
        MtimeFilmT filmT = null;
        if (searchType == 0) {
            filmT = mtimeFilmTMapper.selectById(Integer.parseInt(searchNameOrId));
        }
        if(searchType == 1){
            searchNameOrId = "%" + searchNameOrId + "%" ;
            filmT = mtimeFilmTMapper.selectByName(searchNameOrId);
        }
        if (filmT != null ){
            MtimeFilmInfoT mtimeFilmInfoT = mtimeFilmInfoTMapper.selectById(filmT.getUuid());
            String filmCats = filmT.getFilmCats();
            StringBuilder info01 = new StringBuilder();
            String[] split = filmCats.split("#");
            for (String catId : split) {
                if (!"".equals(catId)) {
                    MtimeCatDictT catDictT = mtimeCatDictTMapper.selectById(catId);
                    info01.append(catDictT.getShowName());
                }
            }
            dataFilmInformationVo.setInfo01(info01.toString());
            MtimeSourceDictT sourceDictT = mtimeSourceDictTMapper.selectById(filmT.getFilmSource());
            StringBuilder info02 = new StringBuilder();
            info02.append(sourceDictT.getShowName()).append("/").append(mtimeFilmInfoT.getFilmLength()).append("分钟");
            dataFilmInformationVo.setInfo02(info02.toString());
            StringBuilder info03 = new StringBuilder();
            info03.append(filmT.getFilmTime()).append(sourceDictT.getShowName()).append("上映");
            dataFilmInformationVo.setInfo03(info03.toString());
            List<Actors> actorsList = new ArrayList<>();
            List<MtimeFilmActorT> filmActorT = mtimeFilmActorTMapper.selectListById(filmT.getUuid());
            for (MtimeFilmActorT actorT : filmActorT) {
                if (actorT.getActorId() == 1) {
                    MtimeActorT director = mtimeActorTMapper.selectById(actorT.getActorId());
                    directorVo.setDirectorName(director.getActorName());
                    directorVo.setImgAddress(director.getActorImg());
                } else {
                    MtimeActorT actor = mtimeActorTMapper.selectById(actorT.getActorId());
                    Actors actors = new Actors();
                    actors.setDirectorName(actor.getActorName());
                    actors.setRoleName(actorT.getRoleName());
                    actors.setImgAddress(actor.getActorImg());
                    actorsList.add(actors);
                }
            }
            actorDirector.setDirector(directorVo);
            actorDirector.setActors(actorsList);
            String[] imags = mtimeFilmInfoT.getFilmImgs().split(",");
            DataFilmInformationImgsVo imgsVo = new DataFilmInformationImgsVo();
            imgsVo.setMainImg(imags[0]);
            imgsVo.setImg01(imags[1]);
            imgsVo.setImg02(imags[2]);
            imgsVo.setImg03(imags[3]);
            imgsVo.setImg04(imags[4]);
            dataFilmInformationVo.setImgs(imgsVo);
            filmInformationVo.setStatus(0);
            filmInformationVo.setImgPre(filmT.getImgAddress());
            filmInformationVo.setData(dataFilmInformationVo);
            dataFilmInformationVo.setFilmEnName(mtimeFilmInfoT.getFilmEnName());
            dataFilmInformationVo.setFilmId(filmT.getUuid());
            dataFilmInformationVo.setFilmName(filmT.getFilmName());
            dataFilmInformationVo.setImgAddress(filmT.getImgAddress());
            dataFilmInformationVo.setScore(filmT.getFilmScore());
            dataFilmInformationVo.setScoreNum(mtimeFilmInfoT.getFilmScoreNum().toString());
            dataFilmInformationVo.setTotalBox(filmT.getFilmBoxOffice().toString());
            InfoDataFilmInformationVo info04 = new InfoDataFilmInformationVo();
            info04.setBiography(mtimeFilmInfoT.getBiography());
            info04.setActors(actorDirector);
            dataFilmInformationVo.setInfo04(info04);
            filmInformationVo.setData(dataFilmInformationVo);
            return filmInformationVo;
        }else {
            return null;
        }
    }
}
