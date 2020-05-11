package com.hdgs.great.object.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 位置实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {

    private Integer lid;
    private Integer uid;
    private double longtitude;//位置的经度
    private double latitude;//位置的纬度

    //日志字段
    private String created_User;
    private Date created_Time;
    private String modified_User;
    private Date modified_Time;


}
