package com.hdgs.great.object.service;

import com.alibaba.fastjson.JSONObject;
import com.hdgs.great.object.repository.AddressRepository;
import com.hdgs.great.object.repository.NotificationRepository;
import com.hdgs.great.object.repository.WxAccountRepository;
import com.hdgs.great.object.domain.Notification;
import com.hdgs.great.object.domain.WxAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

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
    public Notification insertSystemNotification(String toopenid, String title, String msg) {
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
    public Notification insertNotification(String fromopenid,String toopenid,String title, String msg) {
        Notification notification = new Notification(fromopenid,toopenid,title,msg);

        //封装时间日志
        Date now = new Date();
        notification.setCreated_User(toopenid);
        notification.setCreated_Time(now);
        notification.setModified_User(toopenid);
        notification.setModified_Time(now);

        int insertNum=notificationRepository.insertByNotification(notification);
        if(insertNum != 1){
            return null;
        }
        return notification;
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
            String fromopidtemp = notification.getFrom_Open_Id();
            WxAccount fromwxAccount = wxAccountRepository.findByOpenid(fromopidtemp);
            JSONObject temp = new JSONObject();
            temp.put("notificationid", notification.getNid());
            if (!notification.getFrom_Open_Id().equals("0")) {
                temp.put("fromnickname", fromwxAccount.getNick_Name());
                temp.put("fromavatarurl", fromwxAccount.getAvatar_Url());
            } else {
                temp.put("fromnickname", "系统消息");
                temp.put("fromavatarurl", "/sysimg/sysnotification.png");
            }
            temp.put("title",notification.getTitle());
            temp.put("msg", notification.getMessage());
            temp.put("read",notification.getRead());
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
        notificationRepository.readNotification(notificationid);
        String fromopid = notification.getFrom_Open_Id();
        WxAccount fromwxAccount = wxAccountRepository.findByOpenid(fromopid);
        responsejson.put("notificationid", notification.getNid());
        if (!notification.getFrom_Open_Id().equals("0")) {
            responsejson.put("fromnickname", fromwxAccount.getNick_Name());
            responsejson.put("fromavatarurl", fromwxAccount.getAvatar_Url());
        } else {
            responsejson.put("fromnickname", "系统消息");
            responsejson.put("fromavatarurl", "/sysimg/sysnotification.png");
        }
        responsejson.put("title",notification.getTitle());
        responsejson.put("msg", notification.getMessage());
        return responsejson;
    }


    @Override
    public ArrayList<JSONObject> getAllSystemNotification(String to_Open_Id) {
        Notification[] notifications = notificationRepository.findAllSystemNotification(to_Open_Id);
        ArrayList<JSONObject> responsejson = new ArrayList<>();
        for (Notification notification : notifications) {
            JSONObject temp = new JSONObject();
            temp.put("notificationid", notification.getNid());
                temp.put("fromnickname", "系统消息");
                temp.put("fromavatarurl", "/sysimg/sysnotification.png");
            temp.put("title",notification.getTitle());
            temp.put("msg", notification.getMessage());
            temp.put("read",notification.getRead());
            responsejson.add(temp);
        }
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
