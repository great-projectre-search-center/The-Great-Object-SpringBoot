package com.hdgs.great.object.controller;

import com.alibaba.fastjson.JSONObject;
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
    public ArrayList<JSONObject> getNotification(@RequestParam("openid") String openid) {
        ArrayList<JSONObject> notification = notificationService.getAllNotificationByToOpenid(openid);
        return notification;
    }

    @PreAuthorize("hasAuthority('ROLE_WXUSER')")
    @GetMapping("/{openid}/getsystemnotification")
    public ArrayList<JSONObject> getSystemNotification(@RequestParam("openid") String openid){
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
    public JSONObject getOneNotification(@RequestParam("openid") String openid, @RequestParam("notificationid") int notificationid) {
        JSONObject notification = notificationService.getNotificationById(notificationid);
        return notification;
    }

    /**
     * 删除通知
     *
     * @param openid
     * @param jsonObject
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_WXUSER')")
    @DeleteMapping("/{notificationid}/deletenotification/")
    public JSONObject deleteNotification(@RequestParam("openid") String openid, @RequestBody JSONObject jsonObject) {
        int notificationId = jsonObject.getInteger("id");
        boolean result = notificationService.deleteNotification(openid, notificationId);
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
    @PostMapping("/{openid}/postnotification")
    public JSONObject postNotification(@RequestParam("openid") String fromopenid,String toopenid ,String title, String msg) {
        boolean result = notificationService.insertNotification(fromopenid,toopenid,title, msg);
        JSONObject responseJSON = new JSONObject();
        responseJSON.put("isOK", result);
        return responseJSON;
    }
}
