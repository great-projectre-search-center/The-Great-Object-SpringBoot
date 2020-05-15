package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.Reward;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class RewardServiceTests {

    @Autowired
    RewardService rewardService;

    @Test
    public void change(){
        Reward reward=new Reward("aa",new Date(),"24154",100,1000);
        rewardService.change(reward,100);
    }
    @Test
    public void getDetails(){
        Reward[] reward=rewardService.getDetails("aa");
        System.out.println(reward.toString());
    }
    @Test
    public void getLastChanged(){
        Reward reward=rewardService.getLastChanged("aa");
        System.out.println(reward.toString());

    }

}
