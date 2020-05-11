package com.hdgs.great.object.controller.auth;

import com.alibaba.fastjson.JSONObject;
import com.hdgs.great.object.config.security.GrantedAuthority.WxAuthenticationToken;
import com.hdgs.great.object.domain.WxAccount;
import com.hdgs.great.object.service.UserInfoService;
import com.hdgs.great.object.service.WxAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.IOException;

@RestController
public class UserInfo {


    @Autowired
    WxAccountService wxAccountService;

    @Autowired
    UserInfoService userInfoService;

    /**
     * 获取用户信息
     * @param wxAuthenticationToken
     * @return
     */
    @GetMapping("/getuserinfo")
    @PreAuthorize("hasAuthority('ROLE_WXUSER')")
    public JSONObject getUserInfo(WxAuthenticationToken wxAuthenticationToken) {
        JSONObject responsejson = new JSONObject();

        WxAccount wxAccount = wxAccountService.getWxAccount((Integer) wxAuthenticationToken.getCredentials());
        responsejson.put("nickname", wxAccount.getNick_Name());
        String avatarUrl = wxAccount.getAvatar_Url();
        if (avatarUrl == null || avatarUrl.equals("")) {
            responsejson.put("avatarUrl", "/sysimg/defaultavatar.png");
        } else {
            responsejson.put("avatarUrl", wxAccount.getAvatar_Url());
        }
        return responsejson;
    }

    /**
     * 更改头像
     * @param request
     * @param wxAuthenticationToken
     * @param multipartFile
     * @param servletRequest
     * @return
     */
    @PostMapping("/setavatar")
    @PreAuthorize("hasAuthority('ROLE_WXUSER')")
    public JSONObject setAvatar(ServletRequest request, WxAuthenticationToken wxAuthenticationToken, @RequestParam("file") MultipartFile[] multipartFile, ServletRequest servletRequest)  {

        JSONObject responsejson = new JSONObject();
        MultipartFile avatar = multipartFile[0];

        WxAccount wxAccount = (WxAccount) wxAuthenticationToken.getPrincipal();


        try {
            String avatarname= userInfoService.changeAvatar(wxAccount,avatar);

            String contentpath=servletRequest.getServletContext().getContextPath();
            if(!contentpath.equals("")){
                contentpath=contentpath+"/";
            }
            responsejson.put("errcode",0);
            responsejson.put("url",servletRequest.getScheme()+"://"+servletRequest.getServerName()+":"+servletRequest.getServerPort()+"/"+contentpath+"avatar/"+avatarname);

        } catch (IOException e) {
            e.printStackTrace();
            responsejson.put("errcode",1);
        }



        return responsejson;
    }


}
