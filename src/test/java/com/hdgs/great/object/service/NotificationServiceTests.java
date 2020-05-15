package com.hdgs.great.object.service;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NotificationServiceTests {

    @Autowired
    NotificationService notificationService;


    @Test
    public void insertSystemNotification() {
        notificationService.insertSystemNotification("1", "title", "messge");
    }

    @Test
    public void insertNotification() {
        notificationService.insertNotification("1", 1, "2", 2, "title", "message");
    }

    @Test
    public void getNotificationById() {
        JSONObject jsonObject = notificationService.getNotificationById(1);
        System.out.println(jsonObject.toString());
    }

    @Test
    public void getAllNotificationByToOpenid(){
        notificationService.getAllNotificationByToOpenid("11");
    }
    @Test
    public void deleteNotification(){
        notificationService.deleteNotification("11",10);
    }

}
