package com.hdgs.great.object.controller;

import com.alibaba.fastjson.JSONObject;
import com.hdgs.great.object.domain.Notification;
import com.hdgs.great.object.service.NotificationService;
import com.hdgs.great.object.service.WxAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @Autowired
    WxAccountService wxAccountService;

    /**
     * 获取全部消息通知
     *
     * @param openid
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_WXUSER')")
    @GetMapping("/{openid}/getnotification")
    public ArrayList<JSONObject> getNotification(@PathVariable("openid") String openid) {
        ArrayList<JSONObject> notification = notificationService.getAllNotificationByToOpenid(openid);
        return notification;
    }

    /**
     * 获取某用户的全部系统消息
     * @param openid
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_WXUSER')")
    @GetMapping("/{openid}/getsystemnotification")
    public ArrayList<JSONObject> getSystemNotification(@PathVariable("openid") String openid){
        ArrayList<JSONObject> systemNotification = notificationService.getAllSystemNotification(openid);
        return systemNotification;
    }

    /**
     * 获取一条消息通知
     *
     * @param openid
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_WXUSER')")
    @GetMapping("/{openid}/getnotification/{notificationid}")
    public JSONObject getOneNotification(@PathVariable("openid") String openid, @PathVariable("notificationid") int notificationid) {
        JSONObject notification = notificationService.getNotificationById(notificationid);
        return notification;
    }

    /**
     * 删除通知
     *
     * @param openid
     * @param notificationid
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_WXUSER')")
    @DeleteMapping("/{openid}/deletenotification/{notificationid}")
    public JSONObject deleteNotification(@PathVariable("openid") String openid, @PathVariable("notificationid") int notificationid) {
        boolean result = notificationService.deleteNotification(openid, notificationid);
        JSONObject responseJSON = new JSONObject();
        responseJSON.put("isOK", result);
        return responseJSON;
    }

    /**
     * 发送通知
     * @param fromopenid
     * @param toopenid
     * @param title
     * @param msg
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_WXUSER')")
    @PostMapping("/{fromopenid}/postnotification/toopenid/")
    public JSONObject postNotification(@PathVariable("fromopenid") String fromopenid, @PathVariable("toopenid") String toopenid ,String title, String msg) {
        Notification notification = notificationService.insertNotification(fromopenid,toopenid,title, msg);
        JSONObject responseJSON = new JSONObject();
        responseJSON.put("isOk", notification);
        return responseJSON;
    }

    /**
     * 消息已读
     * @param nid
     * @return
     */
    @PostMapping("/nid/readnotification")
    public JSONObject readNotification(@PathVariable("nid") Integer nid){
        boolean result =notificationService.read(nid);
        JSONObject responseJSON = new JSONObject();
        responseJSON.put("isOk", result);
        return responseJSON;
    }
}
