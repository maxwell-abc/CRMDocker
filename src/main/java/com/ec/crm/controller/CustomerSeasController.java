package com.ec.crm.controller;


import cn.hutool.socket.aio.IoAction;
import com.ec.common.db.fi.po.CustomerProfile;
import com.ec.common.db.fi.po.CustomerSea;
import com.ec.common.db.fi.po.CustomerSeaView;
import com.ec.crm.bean.ResponseJson;
import com.ec.crm.bean.vo.CustomerSeaMapVo;
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


//测试代码。。
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ResponseJson addCustomer() throws IOException{

        List<CustomerSea>  customerSeas = customerSeasService.get();

        if(customerSeas!=null){
            return new ResponseJson(Constant.SUCCESS_CODE,customerSeas);
        }else{
            return new ResponseJson(Constant.FAIL_CODE,"查询客户失败！");
        }
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseJson addCustomerSea(@RequestBody CustomerSea customerSea) throws IOException{

        long flag =customerSeasService.insertSelective(customerSea);
        if(flag==1){
            return new ResponseJson(Constant.SUCCESS_CODE,"添加角色成功！");

        }else if(flag==0) {
            return new ResponseJson(Constant.EXIST_CODE,"添加的角色重复");
        }
        else {
            return new ResponseJson(Constant.FAIL_CODE,"添加角色失败！");
        }

    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseJson updateCustomerSea(@RequestBody CustomerSea customerSea) throws IOException{
        if(customerSeasService.updateByPrimaryKey(customerSea)==1){
            return new ResponseJson(Constant.SUCCESS_CODE,"修改公海成功！");
        }else {
            return new ResponseJson(Constant.FAIL_CODE,"修改公海失败！");
        }

    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseJson deleteCustomerSea(@RequestBody CustomerSea customerSea) throws IOException{
        int result =customerSeasService.deleteByPrimaryKey(customerSea.getId());
        if(result==1){
            return new ResponseJson(Constant.SUCCESS_CODE,"删除成功！");
        }else {
            return new ResponseJson(Constant.FAIL_CODE,"删除失败！");
        }
    }

    @RequestMapping(value = "query-like",method = RequestMethod.POST)
    public ResponseJson slectInfoLike(@RequestBody  CustomerSeaView customerSeaView) throws IOException{
        CustomerSeaMapVo customerSeaMapVo = customerSeasService.slectInfoLike(customerSeaView);
        if(customerSeaMapVo!=null){
        return new ResponseJson(Constant.SUCCESS_CODE,customerSeaMapVo);
    }else {
        return new ResponseJson(Constant.FAIL_CODE,"查询角色失败！");
    }
}



}
