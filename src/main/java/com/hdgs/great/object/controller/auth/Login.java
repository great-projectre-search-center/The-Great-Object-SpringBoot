package com.hdgs.great.object.controller.auth;


import com.alibaba.fastjson.JSONObject;
import com.hdgs.great.object.config.security.GrantedAuthority.WxAuthenticationToken;
import com.hdgs.great.object.domain.WxAccount;
import com.hdgs.great.object.repository.WxAccountRepository;
import com.hdgs.great.object.service.JwtTokenService;
import com.hdgs.great.object.service.PasswordService;
import com.hdgs.great.object.service.UploadFileService;
import com.hdgs.great.object.service.UploadUserInfoService;
import com.hdgs.great.object.util.AccountTypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class Login {


    @Autowired
    PasswordService passwordService;

    @Autowired
    WxAccountRepository wxAccountRepository;

    @Autowired
    UploadFileService uploadFileService;

    @Autowired
    JwtTokenService jwtTokenService;

    @Autowired
    UploadUserInfoService uploadUserInfoService;

    /**
     * 授权登录
     * @param wxAuthenticationToken
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_WXUSER')")
    @PostMapping("/auth/wxlogin")
    public JSONObject wxLogin(WxAuthenticationToken wxAuthenticationToken) {
        WxAccount wxAccount = (WxAccount) wxAuthenticationToken.getPrincipal();

        String token = (String) wxAuthenticationToken.getCredentials();

        JSONObject jsonrestlt = new JSONObject();
        jsonrestlt.put("errcode", "0");
        jsonrestlt.put("token", token);
        jsonrestlt.put("userid", wxAccount.getId());


        if (wxAccount.getNickName() == null) {
            jsonrestlt.put("hasuserinfo", false);
        } else {
            jsonrestlt.put("hasuserinfo", true);
        }
        return jsonrestlt;
    }


    /**
     * 加载用户信息
     * @param userinfo
     * @param wxAuthenticationToken
     * @return
     * @throws IOException
     */
    @PreAuthorize("hasAuthority('ROLE_WXUSER')")
    @PostMapping("/auth/uploadWxUserinfo")
    public String uploadWxUserinfo(@RequestBody JSONObject userinfo, WxAuthenticationToken wxAuthenticationToken) throws IOException {
        uploadUserInfoService.upload((Integer) wxAuthenticationToken.getCredentials(), userinfo);
        return "ok";
    }

    /**
     * 加载头像信息
     * @param wxAuthenticationToken
     * @param file
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_WXUSER')")
    @PostMapping("/auth/uploadAvatar")
    public String uploadAvatar(WxAuthenticationToken wxAuthenticationToken, MultipartFile file) {
        return "";
    }

    /**
     * 用户名密码登录
     * @param requestjson
     * @return
     */
    @PostMapping("/restlogin")
    public JSONObject restLogin(@RequestBody JSONObject requestjson) {
        String nickname = requestjson.getString("nickname");
        String password = requestjson.getString("password");

        JSONObject responsejson=new JSONObject();

        List<WxAccount> wxAccounts = wxAccountRepository.selectByNickName(nickname);

        int sumUuidAccount = 0;
        int index = -1;
        for (WxAccount wxAccount : wxAccounts) {
            index++;
            if (AccountTypeUtil.judge(wxAccount.getOpenId()) == AccountTypeUtil.UUIDACCOUNT) {
                sumUuidAccount++;
            }
        }

        if (sumUuidAccount == 1) {
            if (passwordService.matches(password,wxAccounts.get(index).getEncodedPassword())) {
                responsejson.put("errcode",0);
                responsejson.put("errmsg","");
                String token=jwtTokenService.generateToken(wxAccounts.get(index).getUsername());
                responsejson.put("token",token);

                return responsejson;
            }else {
                responsejson.put("errcode",1);
                responsejson.put("errmsg","用户名或密码错误");

                return responsejson;
            }
        }else if(sumUuidAccount==0){
            responsejson.put("errcode",1);
            responsejson.put("errmsg","用户不存在");

            return responsejson;
        }
        responsejson.put("errcode",1);
        responsejson.put("errmsg","内部错误");//出现了同名用户
        return responsejson;
    }
}
