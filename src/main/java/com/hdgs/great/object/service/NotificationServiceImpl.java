package com.hdgs.great.object.service;

import com.alibaba.fastjson.JSONObject;
import com.hdgs.great.object.repository.NotificationRepository;
import com.hdgs.great.object.repository.WxAccountRepository;
import com.hdgs.great.object.domain.Notification;
import com.hdgs.great.object.domain.WxAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NotificationServiceImpl implements NotificationService {


    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    WxAccountRepository wxAccountRepository;

    /**
     * 增加系统通知
     *
     * @param toopenid
     * @param msg
     * @return
     */
    public boolean insertSystemNotification(String toopenid, String title, String msg) {
        return insertNotification("0", toopenid, title, msg);
    }

    /**
     * 增加通知
     *
     * @param fromopenid
     * @param toopenid
     * @param msg
     * @return
     */
    public boolean insertNotification(String fromopenid, String toopenid, String title, String msg) {
        Notification notification = new Notification(fromopenid, toopenid, title, msg);
        notificationRepository.insertByNotification(notification);
        return true;
    }


    /**
     * 删除通知
     *
     * @param openid
     * @param notificationid
     * @return
     */
    public boolean deleteNotification(String openid, int notificationid) {
        int delnum = notificationRepository.delete(openid, notificationid);
        if (delnum >= 1) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 获取全部通知
     *
     * @param toopenid
     * @return
     */
    public ArrayList<JSONObject> getAllNotificationByToOpenid(String toopenid) {
        Notification[] notifications = notificationRepository.findByToopenid(toopenid);
        ArrayList<JSONObject> responsejson = new ArrayList<>();
        for (Notification notification : notifications) {
            String fromopidtemp = notification.getFromopenid();
            WxAccount fromwxAccount = wxAccountRepository.findByOpenid(fromopidtemp);
            JSONObject temp = new JSONObject();
            temp.put("notificationid", notification.getId());
            if (!notification.getFromopenid().equals("0")) {
                temp.put("fromnickname", fromwxAccount.getNickName());
                temp.put("fromavatarurl", fromwxAccount.getAvatarUrl());
            } else {
                temp.put("fromnickname", "系统消息");
                temp.put("fromavatarurl", "/sysimg/sysnotification.png");
            }
            temp.put("title",notification.getTitle());
            temp.put("msg", notification.getMsg());
            responsejson.add(temp);
        }
        return responsejson;
    }

    /**
     * 根据id获取通知
     *
     * @param notificationid
     * @return
     */
    @Override
    public JSONObject getNotificationById(int notificationid) {
        Notification notification = notificationRepository.findById(notificationid);
        JSONObject responsejson = new JSONObject();

        String fromopid = notification.getFromopenid();
        WxAccount fromwxAccount = wxAccountRepository.findByOpenid(fromopid);
        responsejson.put("notificationid", notification.getId());
        if (!notification.getFromopenid().equals("0")) {
            responsejson.put("fromnickname", fromwxAccount.getNickName());
            responsejson.put("fromavatarurl", fromwxAccount.getAvatarUrl());
        } else {
            responsejson.put("fromnickname", "系统消息");
            responsejson.put("fromavatarurl", "/sysimg/sysnotification.png");
        }
        responsejson.put("title",notification.getTitle());
        responsejson.put("msg", notification.getMsg());
        return responsejson;
    }

}

/*
responsejson
{
"notificationid"="1",
"fromnickname"="系统消息",
"fromavatarurl"="/sysimg/sysnotification.png",
"title"="我是标题",
"msg"="我是内容",
}


*/