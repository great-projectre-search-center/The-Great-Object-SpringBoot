package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.Appraise;
import com.hdgs.great.object.domain.Order;
import com.hdgs.great.object.repository.AppraiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 评价管理的业务层实现类
 * @author jingfeng999
 */
@Service
public class AppraiseServiceImpl implements AppraiseService {

    @Autowired
    AppraiseRepository appraiseRepository;

    @Autowired
    OrderService orderService;

    @Override
    public void creat(Integer oid, Appraise appraise) {
        //封装订单id
        appraise.setOid(oid);
        //封装日志
        Date now = new Date();
        appraise.setCreated_Time(now);
        long id = oid.longValue();
        Order data = orderService.getOrderById(id);
        String creater = data.getOrder_Creater();
        appraise.setCreated_User(creater);
        appraise.setModified_Time(now);
        appraise.setModified_User(creater);

        //执行插入
        insert(appraise);
    }

    @Override
    public void delete(Integer aid) {
        //执行删除
        deleteByAid(aid);
    }

    @Override
    public Appraise getByAid(Integer aid) {
        return findByAid(aid);
    }

    @Override
    public Appraise getByOid(Integer oid) {
        return findByOid(oid);
    }

    /**
     * 插入评价数据
     * @param appraise 评价数据对象
     */
    private void insert(Appraise appraise){
        Integer rows = appraiseRepository.insert(appraise);
        if(rows != 1){
            return;
        }
    }

    /**
     * 根据评价id删除对应数据
     * @param  aid 评价数据的id
     */
    private void deleteByAid(Integer aid){
        Integer rows = appraiseRepository.deleteByAid(aid);
        if(rows != 1){
            return;
        }
    }

    /**
     * 根据评价id查询对应数据
     * @param aid 评价数据的id
     * @return 评价数据对象
     */
    private Appraise findByAid(Integer aid){
       return appraiseRepository.findByAid(aid);
    }

    /**
     * 根据订单id查询对应评价数据
     * @param oid 订单id
     * @return 评价数据
     */
    private Appraise findByOid(Integer oid){
        return appraiseRepository.findByOid(oid);
    }
}
