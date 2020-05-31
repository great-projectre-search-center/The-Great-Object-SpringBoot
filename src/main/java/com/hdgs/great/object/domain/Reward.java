package com.hdgs.great.object.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reward {

    private int rid;
    private String open_Id; //用户的id
    private Date date;//时间
    private String matter;//事情
    private int changed;//变化
    private int reward;//剩余积分

    //日志字段
    private String created_User;
    private Date created_Time;
    private String modified_User;
    private Date modified_Time;
}
