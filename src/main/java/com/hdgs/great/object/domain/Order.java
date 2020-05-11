package com.hdgs.great.object.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String acctpter_Id;//接单人ID




}
