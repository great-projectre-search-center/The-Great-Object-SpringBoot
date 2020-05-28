package com.hdgs.great.object.service;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class NotificationServiceTests {

    @Autowired
    NotificationService notificationService;

    //测试成功
    @Test
    public void insertSystemNotification() {
        notificationService.insertSystemNotification("1", "title", "messege");
    }

    //测试成功
    @Test
    public void insertNotification() {
        notificationService.insertNotification("1", 1, "2", 2, "title", "message");
    }

    //TODO 测试失败
    @Test
    public void getNotificationById() {
        JSONObject jsonObject = notificationService.getNotificationById(3);
        System.out.println(jsonObject.toString());
    }


    //测试成功
    @Test
    public void getAllNotificationByToOpenid(){
        notificationService.getAllNotificationByToOpenid("11");
    }


    //测试成功
    @Test
    public void deleteNotification(){
        notificationService.deleteNotification("2",3);
    }


    @Test
    public void getAllSystemNotification() {
        ArrayList<JSONObject> data = notificationService.getAllSystemNotification();
        for (int i = 0 ; i < data.size() ; i++){
            System.out.println(data.get(i));
        }
    }
}
