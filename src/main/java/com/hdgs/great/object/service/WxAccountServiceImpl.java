package com.hdgs.great.object.service;

import com.alibaba.fastjson.JSONObject;
import com.hdgs.great.object.domain.WxAccount;
import com.hdgs.great.object.repository.WxAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@Service
public class WxAccountServiceImpl implements WxAccountService {

    @Autowired
    PasswordService passwordService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WxAccountRepository wxAccountRepository;

    @Value("${wx.appid}")
    String appid;

    @Value("${wx.secert}")
    String secret;

    @Override
    public WxAccount getWxAccount(int uid) {
        return wxAccountRepository.findById(uid);
    }

    @Override
    public WxAccount getWxAccountByOpenId(String openId) {
        return wxAccountRepository.findByOpenid(openId);
    }

    @Override
    public WxAccount addAccount(String nickName, String password) {
        String uuid = UUID.randomUUID().toString();
        String encodedPassword = passwordService.encode(password);

        int insertcount = 0;
        WxAccount newAccount = new WxAccount(uuid, nickName, encodedPassword);

        try {
            insertcount = wxAccountRepository.insertByNickNameEncodedPassword(newAccount);
        } catch (org.springframework.dao.DuplicateKeyException e) {
            addAccount(nickName, password);
        }
        return newAccount;
    }

    @Override
    public String code2Session(String js_code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("appid", appid);
        params.add("secret", secret);
        params.add("js_code", js_code);
        params.add("grant_type", "authorization_code");

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url).queryParams(params);
        URI uri = uriComponentsBuilder.build().encode().toUri();
        System.out.println(uri.toString());

        String code2SessionString = restTemplate.getForObject(uri, String.class);

        System.out.println(code2SessionString);
        JSONObject code2SessionJson = JSONObject.parseObject(code2SessionString);
        if (code2SessionJson.containsKey("errcode")) {
            return null;
        } else {
            return code2SessionJson.getString("openid");
        }
    }

    @Override
    public boolean isNicknameExist(String nickName) {
        int count = wxAccountRepository.selectNicknamecount(nickName);
        if (count == 0) return false;
        return true;
    }
}
