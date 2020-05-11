package com.hdgs.great.object.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 收获地址的实体类
 * @author jingfeng999
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

}
