package com.ec.crm.service.impl;


import com.ec.crm.bean.CustomerSeas;
import com.ec.crm.mapper.CustomerSMapper;
//import com.ec.crm.mapper.CustomerSeasMapper;
import com.ec.crm.service.CustomerSeasService;
//import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Slf4j
@Service(value = "CustomerSeasService")
public class CustomerSeasImpl implements CustomerSeasService {

    @Resource
    CustomerSMapper customerSMapper;

    @Override
    public List<CustomerSeas> getCustomerSeas(){

        List<CustomerSeas> customerSeasList = customerSMapper.getCustomerSea();
        return customerSeasList;

    }
}
