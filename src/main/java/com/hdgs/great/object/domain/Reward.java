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
    String openid; //用户的id
    Date date;//时间
    String matter;//事情
    int changed;//变化
    int reward;//剩余积分

}
