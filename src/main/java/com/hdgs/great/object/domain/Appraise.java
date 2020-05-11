package com.hdgs.great.object.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 评价管理的实体类
 * @author jingfeng999
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appraise {
    Integer aid; //评价id
    Integer oid; //订单id
    Integer grade; //评价等级0，1，2，3
    String content; //评价内容

    //日志
    String created_User;
    Date created_Time;
    String modified_User;
    Date modified_Time;

}
