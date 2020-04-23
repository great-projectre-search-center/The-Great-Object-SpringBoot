package com.hdgs.great.object.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;

public interface MapService {

    /**
     * 地点搜索
     * @param keyword
     * @param boundary
     * @param key
     * @param orderby
     * @param filter
     * @param page_size
     * @param page_index
     * @param output
     * @param callback
     * @return
     */
    public JSONObject search(String keyword, String boundary, String key, String orderby, String filter, Integer page_size, Integer page_index, JSONObject output, JSONPObject callback);

    /**
     * IP定位
     * @param ip
     * @param key
     * @param output
     * @param callback
     * @return
     */
    public JSONObject ipLocation(String ip, String key, JSONObject output, JSONPObject callback);

    public void helloworld();
}
