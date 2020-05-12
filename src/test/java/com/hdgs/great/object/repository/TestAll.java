package com.hdgs.great.object.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jingfeng999
 * @create 2020-05-11 13:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAll {

    @Autowired
    WxAccountRepository wxAccountRepository;

    @Test
    public void a(){
        System.out.println("#########################!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
