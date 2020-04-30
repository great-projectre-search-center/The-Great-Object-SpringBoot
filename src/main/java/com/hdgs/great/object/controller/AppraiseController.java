package com.hdgs.great.object.controller;

import com.hdgs.great.object.domain.Appraise;
import com.hdgs.great.object.service.AppraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评价管理的控制层
 * @author jingfeng999
 */
@RestController
@RequestMapping("appraise")
public class AppraiseController {

    @Autowired
    AppraiseService appraiseService;

    @RequestMapping("create")
    public String  create(Appraise appraise, Integer oid){
        //执行插入
        appraiseService.creat(oid, appraise);

        //响应
        return  "OK";
    }

    @RequestMapping("{aid}/delete")
    public String delete(@PathVariable("aid") Integer aid){
        //执行删除
        appraiseService.delete(aid);

        //响应
        return "OK";
    }

    @GetMapping("{aid}/get")
    public Appraise getByAid(@PathVariable("aid") Integer aid){
        //执行查询
        Appraise data = appraiseService.getByAid(aid);

        //响应
        return  data;
    }

    @GetMapping("/")
    public Appraise getByOid(Integer oid){
        //执行查询
        Appraise data = appraiseService.getByOid(oid);

        //响应
        return data;
    }
}
