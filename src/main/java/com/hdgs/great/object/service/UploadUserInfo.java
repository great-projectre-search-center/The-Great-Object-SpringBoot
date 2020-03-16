package com.hdgs.great.object.service;

import com.alibaba.fastjson.JSONObject;

public interface UploadUserInfo {
    public boolean upload(int id, JSONObject userinfo);
}
