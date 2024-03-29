package com.stylefeng.guns.rest.persistence.model;

import java.io.Serializable;

public class FilmsGetVo implements Serializable {

    private int showType;

    private int sortId;

    private int catId;

    private int sourceId;

    private int yearId;

    private int nowPage;

    private int pageSizel;


    public int getShowType() {
        return showType;
    }

    public void setShowType(int showType) {
        this.showType = showType;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public int getYearId() {
        return yearId;
    }

    public void setYearId(int yearId) {
        this.yearId = yearId;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getPageSizel() {
        return pageSizel;
    }

    public void setPageSizel(int pageSizel) {
        this.pageSizel = pageSizel;
    }
}
