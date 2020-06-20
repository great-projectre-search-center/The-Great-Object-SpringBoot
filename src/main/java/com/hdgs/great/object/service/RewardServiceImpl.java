package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.Reward;
import com.hdgs.great.object.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RewardServiceImpl implements RewardService {

    @Autowired
    RewardRepository rewardRepository;
    /**
     * 变动积分
     *
     * @param reward
     * @return
     */
    @Override
    public boolean change(Reward reward) {
        return rewardRepository.change(reward)?true:false;
    }

    /**
     * 获取用户的积分变动明细
     *
     * @param openid
     * @return
     */
    @Override
    public Reward[] getDetails(String openid) {
        return rewardRepository.getDetails(openid);
    }

    /**
     * 获取用户最后一次变动信息
     *
     * @param openid
     * @return
     */
    @Override
    public Reward getLastChanged(String openid) {
        Reward reward=rewardRepository.getLastChanged(openid);
        if(reward==null){
            Reward reward1=new Reward();
            reward1.setOpen_Id(openid);
            reward1.setCreated_Time(new Date());
            reward1.setMatter("新用户");
            reward1.setChanged(100);
            reward1.setReward(100);
            change(reward1);
            getLastChanged(openid);
        }
        return rewardRepository.getLastChanged(openid);
    }
}
