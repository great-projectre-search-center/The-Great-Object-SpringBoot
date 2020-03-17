package com.hdgs.great.object.service;

import com.alibaba.fastjson.JSONObject;

public interface UploadUserInfoService {
    /**
     * 上传个人信息
     * @param id
     * @param userinfo
     * @return
     */
    public boolean upload(int id, JSONObject userinfo);
}
