package com.ec.crm.controller;

import com.ec.common.db.fi.po.CustomerMySale;
import com.ec.common.db.fi.po.CustomerSaleView;
import com.ec.common.db.fi.po.CustomerSales;
import com.ec.crm.bean.ResponseJson;
import com.ec.crm.bean.vo.CustomerSaleMapVo;
import com.ec.crm.constant.Constant;
import com.ec.crm.service.CustomerSaleService;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/customersale")
public class CustomerSaleController {

    @Autowired
    CustomerSaleService customerSaleService;

    @RequestMapping(value = "/query-like",method = RequestMethod.POST)
    public ResponseJson selectByType(@RequestBody CustomerSaleView customerSaleView)throws IOException{

        CustomerSaleMapVo customerSalesList = customerSaleService.selectByType(customerSaleView);
        if (customerSalesList!=null){

            return new ResponseJson(Constant.SUCCESS_CODE,customerSalesList);
        }else {
            return new ResponseJson(Constant.FAIL_CODE,"查询失败");

        }
    }

}
