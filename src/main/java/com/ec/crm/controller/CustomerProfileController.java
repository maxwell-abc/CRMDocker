package com.ec.crm.controller;


import com.ec.common.db.cas.po.SubSystemInfo;
import com.ec.crm.bean.ResponseJson;
import com.ec.crm.constant.Constant;
import com.ec.crm.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/customerprofile")
public class CustomerProfileController {
    @Autowired
    CustomerProfileService customerProfileService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseJson addCustomer(@RequestBody Integer a) throws IOException{

        SubSystemInfo subSystemInfo = customerProfileService.insert(a);

        if(subSystemInfo!=null){
            return new ResponseJson(Constant.SUCCESS_CODE,subSystemInfo);
        }else{
            return new ResponseJson(Constant.FAIL_CODE,"查询客户失败！");
        }
    }
}
