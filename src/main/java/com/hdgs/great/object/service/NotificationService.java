package com.hdgs.great.object.service;

import com.alibaba.fastjson.JSONObject;
import com.hdgs.great.object.domain.WxAccount;

import java.util.ArrayList;

public interface NotificationService {

    /**
     * 增加系统通知
     *
     * @param toopenid
     * @param msg
     * @return
     */
    public boolean insertSystemNotification(String toopenid, String msg);

    /**
     * 增加通知
     *
     * @param fromopenid
     * @param toopenid
     * @param msg
     * @return
     */
    public boolean insertNotification(String fromopenid, String toopenid, String msg);

    /**
     * 删除通知
     *
     * @param wxAccount
     * @param notificationid
     * @return
     */
    public boolean deleteNotification(WxAccount wxAccount, int notificationid);

    /**
     * 获取所有通知
     *
     * @param toopenid
     * @return
     */
    public ArrayList<JSONObject> getAllNotificationByToOpenid(String toopenid);
}
