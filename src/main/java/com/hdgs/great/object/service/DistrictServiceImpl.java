package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.District;
import com.hdgs.great.object.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jingfeng999
 */
@Service
public class DistrictServiceImpl implements DistrictService{

    @Autowired
    DistrictRepository districtRepository;

    @Override
    public List<District> getByParent(String parent) {
        return findByParent(parent);
    }

    @Override
    public District getByCode(String code) {
        return findByCode(code);
    }

    /**
     * 根据父级代号获得全国所有省/某省所有市/某市所有区
     * @param parent 父级代号，若要获得全国所有省，parent应该为86
     * @return 返回全国所有省/某省所有市/某市所有区的集合
     */
    private List<District> findByParent(String parent){
        return districtRepository.findByParent(parent);
    }

    /**
     * 根据省市区代号查看详情信息
     * @param code 省市区的代号
     * @return 返回代号对应的详情信息，若找不到，则返回null
     */
    private District findByCode(String code) {
        return districtRepository.findByCode(code);
    }
}
