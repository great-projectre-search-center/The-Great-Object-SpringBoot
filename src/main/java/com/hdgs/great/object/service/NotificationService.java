package com.hdgs.great.object.service;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

public interface NotificationService {

    /**
     * 增加系统通知
     *
     * @param toopenid
     * @param msg
     * @return
     */
    public boolean insertSystemNotification(String toopenid,String title, String msg);

    /**
     * 增加通知
     *
     * @param fromopenid
     * @param toopenid
     * @param msg
     * @return
     */
    public boolean insertNotification(String fromopenid,String toopenid,String title, String msg);

    /**
     * 删除通知
     *
     * @param openid
     * @param notificationid
     * @return
     */
    public boolean deleteNotification(String openid, int notificationid);

    /**
     * 获取所有通知
     *
     * @param toopenid
     * @return
     */
    public ArrayList<JSONObject> getAllNotificationByToOpenid(String toopenid);

    /**
     * 根据id获取通知
     *
     * @param notificationid
     * @return
     */
    public JSONObject getNotificationById(int notificationid);

    /**
     *  获取全部系统通知
     * @return
     */
    public ArrayList<JSONObject> getAllSystemNotification(String to_Open_Id);
}
