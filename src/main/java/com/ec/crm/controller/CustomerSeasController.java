package com.ec.crm.controller;

import com.ec.crm.bean.CustomerSeas;
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
@RequestMapping("/customerseas")
public class CustomerSeasController {
    @Autowired
    CustomerSeasService customerSeasService;

    @RequestMapping(value = "select",method = RequestMethod.GET)
    public ResponseJson getCustomerSeas() throws IOException{
        List<CustomerSeas> customerSeas= customerSeasService.getCustomerSeas();
        if(customerSeas.size()>0){
            return new ResponseJson(Constant.SUCCESS_CODE,customerSeas);
        }else {
            return new ResponseJson(Constant.FAIL_CODE,"获取失败");
        }

    }
}
