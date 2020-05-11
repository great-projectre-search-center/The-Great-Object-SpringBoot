package com.hdgs.great.object.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 通知实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {

    private Integer nid;
    private String from_Open_Id;
    private Integer from_Uid;
    private String to_Open_Id;
    private Integer to_Uid;
    private String title;
    private String message;

    //日志字段
    private String created_User;
    private Date created_Time;
    private String modified_User;
    private Date modified_Time;

    //除了nid和日志的全属性构造器
    public Notification(String from_Open_Id, Integer from_Uid, String to_Open_Id, Integer to_Uid, String title, String message) {
        this.from_Open_Id = from_Open_Id;
        this.from_Uid = from_Uid;
        this.to_Open_Id = to_Open_Id;
        this.to_Uid = to_Uid;
        this.title = title;
        this.message = message;
    }
}
