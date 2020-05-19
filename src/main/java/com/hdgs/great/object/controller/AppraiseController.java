package com.hdgs.great.object.controller;

import com.hdgs.great.object.domain.Appraise;
import com.hdgs.great.object.service.AppraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 评价管理的控制层(已测试)
 *
 * @author jingfeng999
 */
@RestController
@RequestMapping("/appraise")
public class AppraiseController {

    @Autowired
    AppraiseService appraiseService;

    /**
     * 添加评价
     *
     * @param appraise
     * @param oid
     * @return
     */
    @PostMapping("/create")
    public String create(@RequestParam(value = "appraise") Appraise appraise,
                         @RequestParam(value = "oid") Integer oid) {
        //执行插入
        appraiseService.creat(oid, appraise);

        //响应
        return "OK";
    }

    /**
     * 删除评价
     *
     * @param aid
     * @return
     */
    @DeleteMapping("/{aid}/delete")
    public String delete(@PathVariable("aid") Integer aid) {
        //执行删除
        appraiseService.delete(aid);

        //响应
        return "OK";
    }

    /**
     * 查询某个评价
     *
     * @param aid
     * @return
     */
    @GetMapping("/{aid}/get")
    public Appraise getByAid(@PathVariable("aid") Integer aid) {
        //执行查询
        Appraise data = appraiseService.getByAid(aid);

        //响应
        return data;
    }

    /**
     * 根据某订单的所有评价
     *
     * @param oid
     * @return
     */
    @GetMapping("/{oid}/")
    public Appraise getByOid(@PathVariable("oid") Integer oid) {
        //执行查询
        Appraise data = appraiseService.getByOid(oid);

        //响应
        return data;
    }
}
