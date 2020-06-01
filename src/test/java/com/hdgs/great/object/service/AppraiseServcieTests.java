package com.hdgs.great.object.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppraiseServcieTests {

    @Autowired
    AppraiseService appraiseService;

    //测试成功
    @Test
    public void create(){
        Appraise appraise =new Appraise();
        appraise.setContent("CDC等等");
        appraiseService.creat(1,appraise);
    }

    //测试成功
    @Test
    public void getByAid(){
        Appraise data = appraiseService.getByAid(90910);
        System.out.println(data);
    }

    //测试成功
    @Test
    public void getByOid(){
        Appraise data = appraiseService.getByOid(1);
        System.out.println(data);
    }

}
