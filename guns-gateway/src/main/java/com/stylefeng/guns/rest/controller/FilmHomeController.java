package com.stylefeng.guns.rest.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.model.*;
import com.stylefeng.guns.rest.service.FilmAPIService;
 import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmHomeController {


    @Reference
    FilmAPIService filmAPIService;


    //1、首页接口
    @RequestMapping("/home")
    @ResponseBody
    public Object mtimeFilmT(){
        FilmHomeVo filmHomeVo = filmAPIService.selectHomeFilm();
        if (filmHomeVo != null){
            return filmHomeVo;
        }else {
            return new FilmStatus(1,"查询失败，无banner可加载");
        }
    }

    //2、影片条件列表查询接口
    @RequestMapping("/getConditionList")
    public Object getConditionList(SeachCondition seachCondition){
        SeachConditionVo seachConditionVo =filmAPIService.selectAllBySeachCondition(seachCondition);
        if (seachConditionVo != null) {
            return seachConditionVo;
        }else {
            return new FilmStatus(0,"查询失败，无条件可加载");
        }
    }

    //3、影片查询接口
    @RequestMapping("/getFilms")
    public Object getFilms(FilmsGetVo filmsGetVo){
        FilmsVo filmsVo = filmAPIService.findFilms(filmsGetVo);
        return null;
    }

}
