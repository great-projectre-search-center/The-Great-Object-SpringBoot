package com.hdgs.great.object.repository;

import com.hdgs.great.object.domain.WxAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author jingfeng999
 * @create 2020-05-25 15:23
 */
@SpringBootTest
public class WxAccountMapperTest {

    @Autowired
    WxAccountRepository wxAccountRepository;

    @Test
    public void insertByNickNameEncodedPassword(){
        WxAccount wxAccount = new WxAccount();
        wxAccount.setNick_Name("jingfeng");
        wxAccount.setEncoded_Password("mmmmm");
        wxAccount.setOpen_Id("java");
        for (int i = 0 ; i <5 ; i++){
            wxAccountRepository.insertByNickNameEncodedPassword(wxAccount);
        }
    }

    @Test
    public void updateByWxAccount(){
        WxAccount wxAccount = new WxAccount();
        wxAccount.setUid(1);
        wxAccount.setNick_Name("巨星");
        wxAccount.setEncoded_Password("1234556");
        wxAccount.setOpen_Id("php");
        wxAccountRepository.insertByNickNameEncodedPassword(wxAccount);
    }



    @Test
    public void selectNicknamecount(){
        String nickName = "jingfeng";
        Integer counnt = wxAccountRepository.selectNicknamecount(nickName);
        System.out.println("***********************************************************");
        System.out.println("count = "+ counnt);
        System.out.println("***********************************************************");
    }



    @Test
    public void findByOpenid(){
        String openId = "123";
        WxAccount wxAccount = wxAccountRepository.findByOpenid(openId);
        System.out.println("***********************************************************");
        System.out.println(wxAccount.toString());
        System.out.println("***********************************************************");
    }



    @Test
    public void findById(){
        Integer uid = 1;
        WxAccount wxAccount = wxAccountRepository.findById(uid);
        System.out.println("***********************************************************");
        System.out.println(wxAccount.toString());
        System.out.println("***********************************************************");
    }




    @Test
    public void selectAllByNickName(){
        String nickName = "jingfeng";
        List<WxAccount> list = wxAccountRepository.selectAllByNickName(nickName);
        for (WxAccount wxAccount : list){
            System.out.println("***********************************************************");
            System.out.println(wxAccount.toString());
            System.out.println("***********************************************************");
        }
    }

}
