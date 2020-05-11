package com.hdgs.great.object.repository;

import com.hdgs.great.object.domain.Reward;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RewardRepository {
    /**
     * 积分变动
     * @param reward
     * @return
     */
    @Insert("insert into reward openid=#{openid},date=#{date},matter=#{matter},changed=#{changed},reward=#{lastReward}+#{reward}")
    public boolean change(Reward reward,int lastReward);



    /**
     * 获取某人的交易明细
     * @param openid
     * @return
     */
    @Select("select * from reward where openid=#{openid} order by date desc")
    public Reward[] getDetails(String openid);

    /**
     * 获取某人最后一次变动
     * @param openid
     * @return
     */
    @Select("select * from reward where openid=#{openid} order by date desc limit 1")
    public Reward getLastChanged(String openid);
}
