package com.ec.crm.service.impl;




import com.ec.common.db.fi.mapper.CustomerSeaMapper;
import com.ec.common.db.fi.mapper.custom.CustomCustomerSeaMapper;
import com.ec.common.db.fi.po.CustomerProfile;
import com.ec.common.db.fi.po.CustomerSea;


import com.ec.common.db.fi.po.CustomerSeaView;
import com.ec.crm.bean.vo.CustomerSeaMapVo;
import com.ec.crm.service.CustomerSeasService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;


@Slf4j
@Service(value = "CustomerSeasService")
public class CustomerSeasImpl implements CustomerSeasService {

    @Resource
    CustomCustomerSeaMapper customerCustomerSeaMapper;

    @Resource
    CustomerSeaMapper customerSeaMapper;



    @Override
    public List<CustomerSea> get(){
        List<CustomerSea>   customerSea = customerCustomerSeaMapper.getCustomerSea();
        return customerSea;
    }

    @Override
    public long insertSelective(CustomerSea record){

        if(customerCustomerSeaMapper.isExist(record)!=null){
            return 0;
        }else {

            return customerSeaMapper.insert(record);
        }
    }
    @Override
    public int updateByPrimaryKey(CustomerSea record){
        return customerSeaMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(Long id){
        return customerSeaMapper.deleteByPrimaryKey(id);

    }
    @Override
    public CustomerSeaMapVo slectInfoLike(CustomerSeaView customerSeaView){
        Page<CustomerSea> page = PageHelper.startPage(customerSeaView.getIndex(),customerSeaView.getPageSize())
                .doSelectPage(()-> customerCustomerSeaMapper.selectInfoLike(customerSeaView));

        CustomerSeaMapVo resultMap = new CustomerSeaMapVo();

        resultMap.setTotal(page.getTotal());
        resultMap.setData(page.getResult());
        return resultMap;
    }

}
