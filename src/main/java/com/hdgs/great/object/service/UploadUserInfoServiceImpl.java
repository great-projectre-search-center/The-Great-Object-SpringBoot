package com.hdgs.great.object.service;

import com.alibaba.fastjson.JSONObject;
import com.hdgs.great.object.domain.WxAccount;
import com.hdgs.great.object.repository.WxAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UploadUserInfoServiceImpl implements UploadUserInfoService {

    @Autowired
    WxAccountRepository wxAccountRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean upload(int id, JSONObject userinfo) {
        WxAccount wxAccount = wxAccountRepository.findById(id);
        userinfo = userinfo.getJSONObject("userinfo");
        wxAccount.setCountry(userinfo.getString("country"));
        wxAccount.setGender(userinfo.getString("gender"));
        wxAccount.setProvince(userinfo.getString("province"));
        wxAccount.setCity(userinfo.getString("city"));
        wxAccount.setAvatar_Url(userinfo.getString("avatarUrl"));
        wxAccount.setAvatar_Url(userinfo.getString("avatarUrl"));
        wxAccount.setNick_Name(userinfo.getString("nickName"));
//       wxAccount.set(userinfo.getString("language"));
        wxAccountRepository.updateByWxAccount(wxAccount);
        return true;

    }

}


