package com.ec.crm.controller;


import com.ec.common.db.fi.po.CustomerProfile;
import com.ec.common.db.fi.po.CustomerSea;
import com.ec.crm.bean.ResponseJson;
import com.ec.crm.constant.Constant;
import com.ec.crm.service.CustomerSeasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/customersea")
public class CustomerSeasController {

    @Autowired
    CustomerSeasService customerSeasService;



    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ResponseJson addCustomer() throws IOException{

        List<CustomerSea>  customerSeas = customerSeasService.get();

        if(customerSeas!=null){
            return new ResponseJson(Constant.SUCCESS_CODE,customerSeas);
        }else{
            return new ResponseJson(Constant.FAIL_CODE,"查询客户失败！");
        }
    }

}
