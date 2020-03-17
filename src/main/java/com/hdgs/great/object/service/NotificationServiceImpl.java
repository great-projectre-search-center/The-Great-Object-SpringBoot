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
public class NotificationServiceImpl {


    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    WxAccountRepository wxAccountRepository;

    public boolean insertSystemNotification(String toopenid, String msg) {
        return insertNotification("0", toopenid, msg);
    }


    public boolean insertNotification(String fromopenid, String toopenid, String msg) {
        Notification notification = new Notification();
        notification.setFromopenid(fromopenid);
        notification.setToopenid(toopenid);
        notification.setMsg(msg);

        notificationRepository.insertByNotification(notification);
        return true;
    }

    public boolean deleteNotification(WxAccount wxAccount, int notificationid) {
        String openid = wxAccount.getOpenId();
        int delnum = notificationRepository.delete(openid, notificationid);
        if (delnum >= 1) {
            return true;
        } else {
            return false;
        }
    }


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
            String msg = notification.getMsg();
            if (msg.contains("|")) {
                String[] msgsplit = msg.split("\\|");
                msg = msgsplit[1];
                int feedid = Integer.valueOf(msgsplit[0]);
                temp.put("feedid", feedid);
            }
            temp.put("msg", msg);


            temp.put("id", notification.getId());

            responsejson.add(temp);
        }
        return responsejson;
    }
}
