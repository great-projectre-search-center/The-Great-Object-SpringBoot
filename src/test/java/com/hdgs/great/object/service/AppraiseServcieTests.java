package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.Appraise;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class AppraiseServcieTests {

    @Autowired
    AppraiseService appraiseService;

    @Test
    public void create(){
        Appraise appraise=new Appraise(1,1L,1,"","",new Date(),"juxing",new Date());
        appraiseService.creat(1L,appraise);
    }
}
