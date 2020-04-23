package com.hdgs.great.object.controller.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author jingfeng999
 */
@RestController
@RequestMapping("addresses")
public class AddressController {
    /*
    @Autowired
    AddressService addressService;

    //TODO
    @PostMapping("addnew")
    public String addnew(AddressController address,) {

        // 调用业务层执行添加
        addressService.addnew(address, uid, username);
    }

    //TODO
    @PostMapping("{aid}/delete")
    public String delete(@PathVariable("aid") Integer aid,){

        //调用业务层执行删除
        addressService.deleteByAid(aid, uid, username);

    }

    //TODO
    @GetMapping("/")
    public String getByUid() {

        // 调用业务层获取收获地址数据集合
        List<Address> data = addressService.getByUid(uid);

    }

    //TODO
    @PostMapping("{aid}/update")
    public  String update(@PathVariable("aid") Integer aid,){

        //调用业务层执行修改
        addressService.update(aid, uid, username, address);

    }
    */
}
