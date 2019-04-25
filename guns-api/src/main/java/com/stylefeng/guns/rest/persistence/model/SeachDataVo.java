package com.stylefeng.guns.rest.persistence.model;

import com.stylefeng.guns.rest.persistence.model.CatInfo;

import java.io.Serializable;
import java.util.List;

public class SeachDataVo implements Serializable {

    List<CatInfo> catInfo;

    List<SourceInfo> sourceInfo;

    List<YearInfo> yearInfo;

    public List<CatInfo> getCatInfo() {
        return catInfo;
    }

    public void setCatInfo(List<CatInfo> catInfo) {
        this.catInfo = catInfo;
    }

    public List<SourceInfo> getSourceInfo() {
        return sourceInfo;
    }

    public void setSourceInfo(List<SourceInfo> sourceInfo) {
        this.sourceInfo = sourceInfo;
    }

    public List<YearInfo> getYearInfo() {
        return yearInfo;
    }

    public void setYearInfo(List<YearInfo> yearInfo) {
        this.yearInfo = yearInfo;
    }
}
