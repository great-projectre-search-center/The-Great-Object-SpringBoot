package com.hdgs.great.object.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 订单实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    private Integer oid;//订单Id
    private String title;//订单名称
    private String catalog;//订单类型
    private String creater_Id;//放单人Id
    private String creater_Name;//放单人
    private String creater_Tel;//放单人手机号码
    private Double creater_Longitude;//放单人位置经度
    private Double creater_Latitude;//放单人位置纬度
    private Double shops_Longtitude;//商家位置经度
    private Double shops_Latitude;//商家位置纬度
    private String accepter_Id;//接单人ID
    private Date create_Date;//订单放单时间
    private Date accept_Date;//订单接受时间
    private String public_field1;//公共字段1
    private String public_field2;//公共字段2
    private Integer estimated_Worth;//预估价值
    private String remark;//备注
    private Integer aid;//评价id
    private Integer reward;//奖励积分
    private Integer status;//订单状态,0未接单,1已接单,2送货中,3已接收,4已评价,5已取消,6已删除

    //日志字段
    private String created_User;
    private Date created_Time;
    private String modified_User;
    private Date modified_Time;




}
