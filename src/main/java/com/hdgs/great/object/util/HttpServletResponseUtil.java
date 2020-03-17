package com.hdgs.great.object.util;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HttpServletResponseUtil {

    /**
     * 输出字符串
     * @param httpServletResponse
     * @param jsonString
     * @throws IOException
     */
    public static void returnString(HttpServletResponse httpServletResponse, String jsonString) throws IOException {

        httpServletResponse.setHeader("content-type", "application/json");
        PrintWriter out = httpServletResponse.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();
    }

    /**
     * 输出JSON
     * @param httpServletResponse
     * @param object
     * @throws IOException
     */
    public static void returnJson(HttpServletResponse httpServletResponse, Object object) throws IOException {

        String jsonString = JSONObject.toJSONString(object);
        httpServletResponse.setHeader("content-type", "application/json");
        PrintWriter out = httpServletResponse.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();

    }

    /**
     * 输出JSON
     * @param httpServletResponse
     * @param jsonObject
     * @throws IOException
     */
    public static void returnJson(HttpServletResponse httpServletResponse, JSONObject jsonObject) throws IOException {

        String jsonString = jsonObject.toJSONString();
        httpServletResponse.setHeader("content-type", "application/json");
        PrintWriter out = httpServletResponse.getWriter();
        out.println(jsonString);
        out.flush();
        out.close();

    }


}
