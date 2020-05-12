package com.hdgs.great.object.repository;

import com.hdgs.great.object.domain.Appraise;

/**
 * 评价管理的持久层接口
 * @author jingfeng999
 */
public interface AppraiseRepository {

    /**
     * 插入评价数据
     * @param appraise 评价数据对象
     * @return 新增订单的id
     */
    Integer insert(Appraise appraise);

    /**
     * 根据评价id删除对应数据
     * @param  aid 评价数据的id
     * @return 受影响的行数
     */
    Integer deleteByAid(Integer aid);

    /**
     * 根据评价id查询对应数据
     * @param aid 评价数据的id
     * @return 评价数据对象
     */
    Appraise findByAid(Integer aid);

    /**
     * 根据订单id查询对应评价数据
     * @param Oid 订单id
     * @return 评价数据
     */
    Appraise findByOid(Integer Oid);

}
