package com.hdgs.great.object.domain;

import lombok.Data;

import java.util.Date;

/**
 * 位置实体类
 */
@Data
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

    //无参构造器
    public Location() {
    }

    //经度纬度的构造器
    public Location(double longtitude, double latitude) {
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

}
