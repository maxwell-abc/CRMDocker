package com.ec.crm.service.impl;


import com.ec.crm.bean.CustomerSeas;
import com.ec.crm.mapper.CustomerSeasMapper;
import com.ec.crm.service.CustomerSeasService;
//import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service(value = "CustomerSeasService")
@MapperScan("com.ec.crm.mapper")
public class CustomerSeasImpl implements CustomerSeasService {

    @Resource
    CustomerSeasMapper customerSeasMapper;

    @Override
    public List<CustomerSeas> getCustomerSeas(){

        List<CustomerSeas> customerSeasList = customerSeasMapper.getCustomerSea();
        return customerSeasList;

    }
}
