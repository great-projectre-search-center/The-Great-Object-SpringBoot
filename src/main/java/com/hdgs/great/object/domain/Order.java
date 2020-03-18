package com.hdgs.great.object.domain;

import java.util.Date;

public class Order {
    private int id;//订单Id
    private Date date;//订单创建时间
    private String user;//放单人
    private String title;//订单题目
    private String content;//订单内容
    private String catalog;//订单类型
    private double longitude;//位置的经度
    private double latitude;//位置的纬度
    private int reward;

    protected Order() {

    }

    public Order(int id, Date date, String user, String title, String content, String catalog, double longitude, double latitude, int reward) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.title = title;
        this.content = content;
        this.catalog = catalog;
        this.longitude = longitude;
        this.latitude = latitude;
        this.reward = reward;
    }

    public Order(String user, String title, String content, String catalog, double longitude, double latitude, int reward) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.catalog = catalog;
        this.longitude = longitude;
        this.latitude = latitude;
        this.reward = reward;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }
}
