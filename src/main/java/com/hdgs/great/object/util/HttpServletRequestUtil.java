package com.hdgs.great.object.util;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpServletRequestUtil {

    /**
     * RequestBody转化为字符串
     * @param request
     * @return
     * @throws IOException
     */
    public static String RequestBody2String(HttpServletRequest request) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    /**
     * RequestBody转化为JSON
     * @param request
     * @return
     * @throws IOException
     */
    public static JSONObject RequestBody2Json(HttpServletRequest request) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        return JSONObject.parseObject(stringBuilder.toString());
    }
}
