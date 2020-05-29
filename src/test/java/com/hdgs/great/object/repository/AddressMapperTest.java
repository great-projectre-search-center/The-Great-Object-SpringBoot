package com.hdgs.great.object.repository;

import com.hdgs.great.object.domain.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author jingfeng999
 * @create 2020-05-17 14:24
 */

@SpringBootTest
public class AddressMapperTest {
    @Autowired
    AddressRepository addressRepository;

    @Test
    public void  add(){
        Address address = new Address();
        address.setName("jingfeng");
        addressRepository.insert(address);
    }

}
