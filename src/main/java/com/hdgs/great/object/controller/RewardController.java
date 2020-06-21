package com.hdgs.great.object.controller;

import com.alibaba.fastjson.JSONObject;
import com.hdgs.great.object.domain.Reward;
import com.hdgs.great.object.service.NotificationService;
import com.hdgs.great.object.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
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

    @Autowired
    NotificationService notificationService;
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

    @PostMapping("/exchange")
    public JSONObject exchange(@RequestBody Reward reward){
        reward.setReward(rewardService.getLastChanged(reward.getOpen_Id()).getReward()+reward.getChanged());

        JSONObject response=new JSONObject();
        if(reward.getReward()<0){
            response.put("isOK",false);
            return response;
        }
        boolean result=rewardService.change(reward) ;
        if(result){

            response.put("isOK",result);
            notificationService.insertSystemNotification(reward.getOpen_Id(),"礼品兑换通知","您已兑换礼品，发货之后将会以短信通知您");
        }
        return response;
    }


}
