package com.hdgs.great.object.domain;

import java.util.Date;

public class Order {
    private Long order_Id;//订单Id
    private String order_Catalog;//订单类型
    private String order_Title;//订单名称
    private Date order_CreateDate;//订单创建时间
    private Date order_AcceptDate;//订单接收时间
    private String order_CreaterId;//放单人Id
    private String order_AccepterId;//接单人Id
    private String order_PublicField1;//公共字段1
    private String order_PublicField2;//公共字段2
    private int order_EstimateWorth;//预估价值
    private String order_Creater;//放单人
    private String order_CreaterTel;//放单人手机号码
    private Location order_CreaterLocation;
    private Location order_ShopsLocation;
    private String order_Remark;//备注
    private String order_Comment;//评价
    private int order_Reward;//奖励积分
    private int order_Status;//订单状态0未接单1已接单2送货中3已接收4已评价5已取消6已删除

    public Order() {
    }

    public Order(Long order_Id, String order_Catalog, String order_Title, Date order_CreateDate, Date order_AcceptDate, String order_CreaterId, String order_AccepterId, String order_PublicField1, String order_PublicField2, int order_EstimateWorth, String order_Creater, String order_CreaterTel, Location order_CreaterLocation, Location order_ShopsLocation, String order_Remark, String order_Comment, int order_Reward, int order_Status) {
        this.order_Id = order_Id;
        this.order_Catalog = order_Catalog;
        this.order_Title = order_Title;
        this.order_CreateDate = order_CreateDate;
        this.order_AcceptDate = order_AcceptDate;
        this.order_CreaterId = order_CreaterId;
        this.order_AccepterId = order_AccepterId;
        this.order_PublicField1 = order_PublicField1;
        this.order_PublicField2 = order_PublicField2;
        this.order_EstimateWorth = order_EstimateWorth;
        this.order_Creater = order_Creater;
        this.order_CreaterTel = order_CreaterTel;
        this.order_CreaterLocation = order_CreaterLocation;
        this.order_ShopsLocation = order_ShopsLocation;
        this.order_Remark = order_Remark;
        this.order_Comment = order_Comment;
        this.order_Reward = order_Reward;
        this.order_Status = order_Status;
    }

    public Long getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(Long order_Id) {
        this.order_Id = order_Id;
    }

    public String getOrder_Catalog() {
        return order_Catalog;
    }

    public void setOrder_Catalog(String order_Catalog) {
        this.order_Catalog = order_Catalog;
    }

    public String getOrder_Title() {
        return order_Title;
    }

    public void setOrder_Title(String order_Title) {
        this.order_Title = order_Title;
    }

    public Date getOrder_CreateDate() {
        return order_CreateDate;
    }

    public void setOrder_CreateDate(Date order_CreateDate) {
        this.order_CreateDate = order_CreateDate;
    }

    public Date getOrder_AcceptDate() {
        return order_AcceptDate;
    }

    public void setOrder_AcceptDate(Date order_AcceptDate) {
        this.order_AcceptDate = order_AcceptDate;
    }

    public String getOrder_CreaterId() {
        return order_CreaterId;
    }

    public void setOrder_CreaterId(String order_CreaterId) {
        this.order_CreaterId = order_CreaterId;
    }

    public String getOrder_AccepterId() {
        return order_AccepterId;
    }

    public void setOrder_AccepterId(String order_AccepterId) {
        this.order_AccepterId = order_AccepterId;
    }

    public String getOrder_PublicField1() {
        return order_PublicField1;
    }

    public void setOrder_PublicField1(String order_PublicField1) {
        this.order_PublicField1 = order_PublicField1;
    }

    public String getOrder_PublicField2() {
        return order_PublicField2;
    }

    public void setOrder_PublicField2(String order_PublicField2) {
        this.order_PublicField2 = order_PublicField2;
    }

    public int getOrder_EstimateWorth() {
        return order_EstimateWorth;
    }

    public void setOrder_EstimateWorth(int order_EstimateWorth) {
        this.order_EstimateWorth = order_EstimateWorth;
    }

    public String getOrder_Creater() {
        return order_Creater;
    }

    public void setOrder_Creater(String order_Creater) {
        this.order_Creater = order_Creater;
    }

    public String getOrder_CreaterTel() {
        return order_CreaterTel;
    }

    public void setOrder_CreaterTel(String order_CreaterTel) {
        this.order_CreaterTel = order_CreaterTel;
    }

    public Location getOrder_CreaterLocation() {
        return order_CreaterLocation;
    }

    public void setOrder_CreaterLocation(Location order_CreaterLocation) {
        this.order_CreaterLocation = order_CreaterLocation;
    }

    public Location getOrder_ShopsLocation() {
        return order_ShopsLocation;
    }

    public void setOrder_ShopsLocation(Location order_ShopsLocation) {
        this.order_ShopsLocation = order_ShopsLocation;
    }

    public String getOrder_Remark() {
        return order_Remark;
    }

    public void setOrder_Remark(String order_Remark) {
        this.order_Remark = order_Remark;
    }

    public String getOrder_Comment() {
        return order_Comment;
    }

    public void setOrder_Comment(String order_Comment) {
        this.order_Comment = order_Comment;
    }

    public int getOrder_Reward() {
        return order_Reward;
    }

    public void setOrder_Reward(int order_Reward) {
        this.order_Reward = order_Reward;
    }

    public int getOrder_Status() {
        return order_Status;
    }

    public void setOrder_Status(int order_Status) {
        this.order_Status = order_Status;
    }
}
