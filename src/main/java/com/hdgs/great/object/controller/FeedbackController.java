package com.hdgs.great.object.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    /**
     * 获取用户反馈
     * @return
     */
    @GetMapping
    public JSONObject feedback(){
        JSONObject responseJSON=new JSONObject();
        responseJSON.put("isOK", true);
        return responseJSON;
    }

}
