package com.hdgs.great.object.domain;

import java.util.Date;

/**
 * 收获地址的实体类
 * @author jingfeng999
 */
public class Address {

    private Integer aid;    //收货地址id
    private Integer uid;    //用户id
    private String name;    //收获人姓名
    private String phone;   //手机号码
    private String province_Code;    //省编号
    private String province_Name;    //省名称
    private String city_Code;    //市编号
    private String city_Name;    //市名称
    private String area_Code;    //区编号
    private String area_Name;    //区名称
    private String address;     //详细收货地址
    private Date receiving_Time;     //收货时间
    //日志字段
    private String created_User;
    private Date created_Time;
    private String modified_User;
    private Date modified_Time;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince_Code() {
        return province_Code;
    }

    public void setProvince_Code(String province_Code) {
        this.province_Code = province_Code;
    }

    public String getProvince_Name() {
        return province_Name;
    }

    public void setProvince_Name(String province_Name) {
        this.province_Name = province_Name;
    }

    public String getCity_Code() {
        return city_Code;
    }

    public void setCity_Code(String city_Code) {
        this.city_Code = city_Code;
    }

    public String getCity_Name() {
        return city_Name;
    }

    public void setCity_Name(String city_Name) {
        this.city_Name = city_Name;
    }

    public String getArea_Code() {
        return area_Code;
    }

    public void setArea_Code(String area_Code) {
        this.area_Code = area_Code;
    }

    public String getArea_Name() {
        return area_Name;
    }

    public void setArea_Name(String area_Name) {
        this.area_Name = area_Name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getReceiving_Time() {
        return receiving_Time;
    }

    public void setReceiving_Time(Date receiving_Time) {
        this.receiving_Time = receiving_Time;
    }

    public String getCreated_User() {
        return created_User;
    }

    public void setCreated_User(String created_User) {
        this.created_User = created_User;
    }

    public Date getCreated_Time() {
        return created_Time;
    }

    public void setCreated_Time(Date created_Time) {
        this.created_Time = created_Time;
    }

    public String getModified_User() {
        return modified_User;
    }

    public void setModified_User(String modified_User) {
        this.modified_User = modified_User;
    }

    public Date getModified_Time() {
        return modified_Time;
    }

    public void setModified_Time(Date modified_Time) {
        this.modified_Time = modified_Time;
    }

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", province_Code='" + province_Code + '\'' +
                ", province_Name='" + province_Name + '\'' +
                ", city_Code='" + city_Code + '\'' +
                ", city_Name='" + city_Name + '\'' +
                ", area_Code='" + area_Code + '\'' +
                ", area_Name='" + area_Name + '\'' +
                ", address='" + address + '\'' +
                ", receivingTime=" + receiving_Time +
                ", created_User='" + created_User + '\'' +
                ", created_Time=" + created_Time +
                ", modified_User='" + modified_User + '\'' +
                ", modified_Time=" + modified_Time +
                '}';
    }
}
