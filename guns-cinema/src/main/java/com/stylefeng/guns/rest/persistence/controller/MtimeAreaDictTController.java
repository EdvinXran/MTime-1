package com.stylefeng.guns.rest.persistence.controller;


import com.stylefeng.guns.rest.persistence.model.MtimeAreaDictT;
import com.stylefeng.guns.rest.persistence.service.IMtimeAreaDictTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 地域信息表 前端控制器
 * </p>
 *
 * @author Gavin
 * @since 2019-04-21
 */
@RestController
@RequestMapping("/mtimeAreaDictT")
public class MtimeAreaDictTController {
    @Autowired
    IMtimeAreaDictTService iMtimeAreaDictTService;

    @RequestMapping("test")
    public MtimeAreaDictT test(String UUID){
        return iMtimeAreaDictTService.selectById(UUID);
    }

}

