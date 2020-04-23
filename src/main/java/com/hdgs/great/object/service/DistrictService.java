package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.District;

import java.util.List;

/**
 * 出路省/市/区数据的业务层接口
 * @author jingfeng999
 */
public interface DistrictService {

    /**
     * 根据父级代号获得全国所有省/某省所有市/某市所有区
     * @param parent 父级代号，若要获得全国所有省，parent应该为86
     * @return 返回全国所有省/某省所有市/某市所有区的集合
     */
    List<District> getByParent(String parent);

    /**
     * 根据省市区代号查看详情信息
     * @param code 省市区的代号
     * @return 返回代号对应的详情信息，若找不到，则返回null
     */
    District getByCode(String code);
}
