package com.stylefeng.guns.rest.model;

import java.io.Serializable;

public class SourceInfo implements Serializable {

    private int sourceId;

    private String sourceName;

    private boolean isActive;

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
