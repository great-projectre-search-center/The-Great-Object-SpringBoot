package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class AddressSercieTests {

    @Autowired
    AddressService addressService;

    @Test
    public void create(){
        Address address=new Address(10,10,"juxing","110","1","beijieng","1","beijing","1","beijing","jingdong",new Date(),"jjj",new Date(),"ajlsdkf",new Date());
        addressService.addNew(address,555,"juxing");
    }


    @Test
    public void  getByUid(){
        List<Address> list=addressService.getByUid(555);
        System.out.println(list.toString());
    }
    @Test
    public void update(){
        Address address=new Address(10,10,"juxing","110","1","beijieng","1","beijing","1","beijing","jingdong",new Date(),"jjj",new Date(),"ajlsdkf",new Date());
        addressService.update(10,555,"juxing",address);
    }

    @Test
    public void deleteById(){
        addressService.deleteByAid(10,555,"juxing");
    }
}
