package com.ec.crm.service.impl;

import com.ec.common.db.fi.mapper.CustomerSeaSalesMapper;
import com.ec.common.db.fi.po.CustomerSeaSales;
import com.ec.crm.service.CustomerFollowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service(value = "CustomerFollowService")
public class CustomerFollowServiceImpl implements CustomerFollowService {

    @Resource
    CustomerSeaSalesMapper customerSeaSalesMapper;

    @Override
    public int addFollow(CustomerSeaSales customerSeaSales){

        int flag = customerSeaSalesMapper.insert(customerSeaSales);
        return flag;
    }

    @Override
    public int deleteFollow(CustomerSeaSales customerSeaSales){
        int flag = customerSeaSalesMapper.deleteByPrimaryKey(customerSeaSales.getId());
        return flag;
    }

    @Override
    public int updateFollow(CustomerSeaSales customerSeaSales){
        int flag = customerSeaSalesMapper.updateByPrimaryKey(customerSeaSales);
        return flag;
    }


}
