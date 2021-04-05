package com.ec.crm.service.impl;




import com.ec.common.db.fi.mapper.custom.CustomCustomerSeaMapper;
import com.ec.common.db.fi.po.CustomerProfile;
import com.ec.common.db.fi.po.CustomerSea;

import com.ec.crm.service.CustomerSeasService;
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
    CustomCustomerSeaMapper customerCustomerSeaMapper;



    @Override
    public List<CustomerSea> get(){
        List<CustomerSea>   customerSea = customerCustomerSeaMapper.getCustomerSea();
        return customerSea;
    }

}
