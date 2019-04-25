package com.stylefeng.guns.mapperTest;

import com.stylefeng.guns.rest.CinemaRestApplication;
import com.stylefeng.guns.rest.persistence.dao.MtimeCinemaTMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Gavin
 * on 2019/4/21 22:32
 */
@SpringBootTest(classes = CinemaRestApplication.class)
@RunWith(SpringRunner.class)
public class CinemaMapperTest {

    @Autowired
    MtimeCinemaTMapper cinemaTMapper;

}
