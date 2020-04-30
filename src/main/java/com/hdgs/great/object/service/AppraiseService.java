package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.Appraise;

/**
 * 评价管理的业务层接口
 * @author jingfeng999
 */
public interface AppraiseService {

    /**
     * 添加评价
     * @param oid 订单id
     * @param appraise 评价数据
     */
    void creat(Integer oid, Appraise appraise);

    /**
     * 根据评价id删除评价数据
     * @param aid 评价id
     */
    void delete(Integer aid);

    /**
     * 根据评价id获取评价数据
     * @return 评价数据
     */
    Appraise getByAid(Integer aid);

    /**
     * 根据订单id获取评价数据
     * @param oid 订单id
     * @return 评价数据
     */
    Appraise getByOid(Integer oid);

}
