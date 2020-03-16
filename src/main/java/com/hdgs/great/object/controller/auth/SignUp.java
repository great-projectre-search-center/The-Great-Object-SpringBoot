package com.hdgs.great.object.controller.auth;


import com.alibaba.fastjson.JSONObject;
import com.hdgs.great.object.domain.WxAccount;
import com.hdgs.great.object.service.JwtTokenService;
import com.hdgs.great.object.service.WxAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SignUp {

    @Autowired
    JwtTokenService jwtTokenService;


    @Autowired
    WxAccountService wxAccountService;


    @PostMapping("/signup")
    public JSONObject signUp(@RequestBody JSONObject requestjson) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        JSONObject responejson = new JSONObject();

        String nickname = requestjson.getString("nickname");
        String password = requestjson.getString("password");
        String repeatpassword = requestjson.getString("repeatpassword");

        int errcode = 0;
        ArrayList<String> errmsgs = new ArrayList<>();


        if (!password.equals(repeatpassword)) {
            errcode = 1;
            errmsgs.add("密码不一致");
        }

        if (wxAccountService.isNicknameExist(nickname) == true) {
            errcode = 1;
            errmsgs.add("昵称已存在");
        }

        WxAccount wxAccount = null;


        if (errcode == 0) {
            wxAccount = wxAccountService.addAccount(nickname, password);
            String jwt_token = jwtTokenService.generateToken(wxAccount.getUsername());
            responejson.put("token", jwt_token);
        }

        responejson.put("errmsg", errmsgs);
        responejson.put("errcode", errcode);

        return responejson;
    }


}
