package com.stylefeng.guns.rest.persistence.model;

import java.io.Serializable;
import java.util.List;

public class DataVo implements Serializable {

    List<MtimeBanner> banners;

    HotFilmsVo hotFilms;

    SoonFilmVo soonFilms;

    List<MtimeFilm> boxRanking;

    List<MtimeFilm> expectRanking;

    List<MtimeFilm> top100;

    public DataVo() {
    }

    public List<MtimeBanner> getBanners() {
        return banners;
    }

    public void setBanners(List<MtimeBanner> banners) {
        this.banners = banners;
    }

    public HotFilmsVo getHotFilms() {
        return hotFilms;
    }

    public void setHotFilms(HotFilmsVo hotFilms) {
        this.hotFilms = hotFilms;
    }

    public SoonFilmVo getSoonFilms() {
        return soonFilms;
    }

    public void setSoonFilms(SoonFilmVo soonFilms) {
        this.soonFilms = soonFilms;
    }

    public List<MtimeFilm> getBoxRanking() {
        return boxRanking;
    }

    public void setBoxRanking(List<MtimeFilm> boxRanking) {
        this.boxRanking = boxRanking;
    }

    public List<MtimeFilm> getExpectRanking() {
        return expectRanking;
    }

    public void setExpectRanking(List<MtimeFilm> expectRanking) {
        this.expectRanking = expectRanking;
    }

    public List<MtimeFilm> getTop100() {
        return top100;
    }

    public void setTop100(List<MtimeFilm> top100) {
        this.top100 = top100;
    }
}
