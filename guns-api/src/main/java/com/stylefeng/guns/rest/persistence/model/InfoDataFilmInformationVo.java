package com.stylefeng.guns.rest.persistence.model;

import java.io.Serializable;

public class InfoDataFilmInformationVo implements Serializable {

    private String biography;

    ActorDirector actors;

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public ActorDirector getActors() {
        return actors;
    }

    public void setActors(ActorDirector actors) {
        this.actors = actors;
    }
}
