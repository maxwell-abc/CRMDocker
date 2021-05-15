package com.ec.crm.service.impl;

import com.ec.common.db.fi.mapper.CustomerSeaSalesMapper;
import com.ec.common.db.fi.mapper.custom.CustomerFollowMapper;
import com.ec.common.db.fi.po.CustomerFollowView;
import com.ec.common.db.fi.po.CustomerSeaSales;
import com.ec.crm.bean.vo.CustomerFollowMapVo;
import com.ec.crm.service.CustomerFollowService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service(value = "CustomerFollowService")
public class CustomerFollowServiceImpl implements CustomerFollowService {

    @Resource
    CustomerSeaSalesMapper customerSeaSalesMapper;

    @Resource
    CustomerFollowMapper customerFollowMapper;

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

    @Override
    public List<CustomerSeaSales> selectFollowById(CustomerFollowView customerFollowView){
        List<CustomerSeaSales> result =customerFollowMapper.selectFolow(customerFollowView);
        return result;

    }

    @Override
    public CustomerFollowMapVo selectFollowByLike(CustomerFollowView customerFollowView){
        Page<CustomerSeaSales> page = PageHelper.startPage(customerFollowView.getIndex(),customerFollowView.getPageSize())
                .doSelectPage(()-> customerFollowMapper.selectFolow(customerFollowView));

        CustomerFollowMapVo result = new CustomerFollowMapVo();
        result.setData(page.getResult());
        result.setTotal(page.getTotal());

        return result;

    }


}
