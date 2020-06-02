package com.hdgs.great.object.controller;

import com.alibaba.fastjson.JSONObject;
import com.hdgs.great.object.domain.Reward;
import com.hdgs.great.object.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author jingfeng999
 * @create 2020-06-02 14:12
 */
@RestController
@RequestMapping("/reward")
public class RewardController {

    @Autowired
    RewardService rewardService;

    /**
     * 获取最后一次积分变动信息
     * @param openid
     * @return
     */
    @GetMapping("/{openid}/getlast")
    public Reward getLastChanged(@PathVariable("openid") String openid){
        //查询
        Reward reward = rewardService.getLastChanged(openid);
        //响应
        return reward;
    }

    /**
     * 积分变动
     * @param reward
     * @return
     */
    @PostMapping("/change")
    public JSONObject change(@RequestBody Reward reward){
        boolean result;
        JSONObject responseJSON = new JSONObject();
        //更改积分
        result = rewardService.change(reward);
        responseJSON.put("isOK", result);
        return responseJSON;
    }

    /**
     * 积分明细
     * @param openid
     * @return
     */
    @GetMapping("/{openid}/getdetails")
    public Reward[] getAll(@PathVariable("openid") String openid){
        //查询
        Reward[] data = rewardService.getDetails(openid);
        //响应
        return  data;
    }

}
