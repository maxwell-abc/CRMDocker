package com.ec.crm.service.impl;

import com.ec.common.db.cas.mapper.SubSystemInfoMapper;
import com.ec.common.db.cas.po.SubSystemInfo;


import com.ec.crm.service.CustomerProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@Slf4j
@Service(value = "CustomerProfileService")
public class CustomerProfileImpl implements CustomerProfileService {

    @Resource
    SubSystemInfoMapper subSystemInfoMapper;

//    @Resource
//    CustomerProfileMapper  customerProfileMapper;


    @Override
    public SubSystemInfo get(Integer a){
        SubSystemInfo subSystemInfo = subSystemInfoMapper.selectByPrimaryKey(a);
        return  subSystemInfo;
    }
}
