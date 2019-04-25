package com.stylefeng.guns.rest.persistence.model;

import com.stylefeng.guns.rest.persistence.model.Actors;
import com.stylefeng.guns.rest.persistence.model.Director;

import java.io.Serializable;
import java.util.List;

public class ActorDirector implements Serializable {

    Director director;

    List<Actors> actors;

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actors> getActors() {
        return actors;
    }

    public void setActors(List<Actors> actors) {
        this.actors = actors;
    }
}
