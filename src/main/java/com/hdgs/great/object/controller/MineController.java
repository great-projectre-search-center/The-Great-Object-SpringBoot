package com.hdgs.great.object.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MineController {
    @PreAuthorize("hasAuthority('ROLE_WXUSER')")
    @GetMapping("/me")
    public JSONObject me(){
        JSONObject responsejson=new JSONObject();
        return responsejson;
    }
}
