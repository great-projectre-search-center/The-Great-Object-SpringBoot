package com.hdgs.great.object.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class MapServiceImpl implements MapService {


    @Autowired
    RestTemplate restTemplate;


    /**
     * 请求API
     * @param url
     * @param params
     * @return
     */
    public JSONObject request(String url, MultiValueMap<String, String> params){
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url).queryParams(params);
        URI uri = uriComponentsBuilder.build().encode().toUri();

        System.out.println(uri.toString());

        JSONObject jsonObject = restTemplate.getForObject(uri, JSONObject.class);

        System.out.println(jsonObject);
        return jsonObject;
    }
    /**
     * 地点搜索
     *
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
    @Override
    public JSONObject search(String keyword, String boundary, String key, String orderby, String filter, Integer page_size, Integer page_index, JSONObject output, JSONPObject callback) {
        String url = "https://apis.map.qq.com/ws/place/v1/search";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("keyword", keyword);
        params.add("boundary", boundary);
        params.add("key", key);
        if (orderby != null) {
            params.add("orderby", orderby);
        }
        if (filter != null) {
            params.add("filter", filter);
        }
        if (page_size != null) {
            params.add("page_size", page_size.toString());
        }
        if (page_index != null) {
            params.add("page_index", page_index.toString());
        }
        if (output != null) {
            params.add("output", output.toString());
        }
        if (callback != null) {
            params.add("callback", callback.toString());
        }

        JSONObject jsonObject=request(url,params);
//        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url).queryParams(params);
//        URI uri = uriComponentsBuilder.build().encode().toUri();
//
//        System.out.println(uri.toString());
//
//        JSONObject jsonObject = restTemplate.getForObject(uri, JSONObject.class);
//
//        System.out.println(jsonObject);

        if (jsonObject.getString("status").equals("0")) {
            return jsonObject;
        }
        JSONObject errorObject = new JSONObject();
        if (jsonObject.getString("status").equals("310")) {
            errorObject.put("error", "请求参数信息有误");
            return errorObject;
        }
        if (jsonObject.getString("status").equals("311")) {
            errorObject.put("error", "Key格式错误");
            return errorObject;
        }
        if (jsonObject.getString("status").equals("306")) {
            errorObject.put("error", "请求有护持信息请检查字符串");
            return errorObject;
        }
        if (jsonObject.getString("status").equals("110")) {
            errorObject.put("error", "请求来源未被授权");
            return errorObject;
        }
        errorObject.put("error", "其他未知错误");
        return errorObject;

    }

    /**
     * IP定位
     * @param ip
     * @param key
     * @param output
     * @param callback
     * @return
     */
    @Override
    public JSONObject ipLocation(String ip, String key, JSONObject output, JSONPObject callback) {
        String url = "https://apis.map.qq.com/ws/location/v1/ip";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        if (ip != null) {
            params.add("ip", ip);
        }

        params.add("key", key);
        if (output != null) {
            params.add("output", output.toString());
        }
        if (callback != null) {
            params.add("callback", callback.toString());
        }
        JSONObject jsonObject=request(url,params);
        if (jsonObject.getString("status").equals("0")) {
            return jsonObject;
        }
        JSONObject errorObject = new JSONObject();
        if (jsonObject.getString("status").equals("310")) {
            errorObject.put("error", "请求参数信息有误");
            return errorObject;
        }
        if (jsonObject.getString("status").equals("311")) {
            errorObject.put("error", "Key格式错误");
            return errorObject;
        }
        if (jsonObject.getString("status").equals("306")) {
            errorObject.put("error", "请求有护持信息请检查字符串");
            return errorObject;
        }
        if (jsonObject.getString("status").equals("110")) {
            errorObject.put("error", "请求来源未被授权");
            return errorObject;
        }
        errorObject.put("error", "其他未知错误");
        return errorObject;
    }

    @Override
    public void helloworld() {
        System.out.println("helloworld");
    }
}
