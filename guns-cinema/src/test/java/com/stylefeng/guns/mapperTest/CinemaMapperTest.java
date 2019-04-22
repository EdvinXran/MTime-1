package com.stylefeng.guns.mapperTest;

import com.stylefeng.guns.rest.GunsRestApplication;
import com.stylefeng.guns.rest.persistence.dao.MtimeCinemaTMapper;
import com.stylefeng.guns.rest.persistence.model.MtimeCinemaT;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Gavin
 * on 2019/4/21 22:32
 */
@SpringBootTest(classes = GunsRestApplication.class)
@RunWith(SpringRunner.class)
public class CinemaMapperTest {

    @Autowired
    MtimeCinemaTMapper cinemaTMapper;
    @Test
    public void myTest1(){
        List<MtimeCinemaT> list = cinemaTMapper.selectCinemasByBrandAndHallTypeAndDistrictId("1", "1", "1");
        for (MtimeCinemaT mtimeCinemaT : list) {
            System.out.println("mtimeCinemaT = " + mtimeCinemaT);
        }
    }

}
