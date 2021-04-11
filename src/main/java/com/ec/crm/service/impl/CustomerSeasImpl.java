package com.ec.crm.service.impl;




import com.ec.common.db.fi.mapper.CustomerContactsMapper;
import com.ec.common.db.fi.mapper.CustomerSeaMapper;
import com.ec.common.db.fi.mapper.custom.CustomCustomerSeaMapper;

import com.ec.common.db.fi.po.CustomerProfile;
import com.ec.common.db.fi.po.CustomerSea;


import com.ec.common.db.fi.po.CustomerSeaView;
import com.ec.crm.bean.vo.CustomerSeaMapVo;
import com.ec.crm.bean.vo.CustomerSeaVo;
import com.ec.crm.service.CustomerSeasService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;


@Slf4j
@Service(value = "CustomerSeasService")
public class CustomerSeasImpl implements CustomerSeasService {

    @Resource
    CustomCustomerSeaMapper customerCustomerSeaMapper;

    @Resource
    CustomerSeaMapper customerSeaMapper;

    @Resource
    CustomerContactsMapper customerContactsMapper;



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
        ArrayList<CustomerSeaVo> customerSeaVo =new ArrayList<>() ;

        for (int i = 0; i < page.size(); i++) {
            CustomerSeaVo vo = new CustomerSeaVo();
            vo.setId(page.getResult().get(i).getId());
            vo.setName(page.getResult().get(i).getName());
            vo.setNumber(page.getResult().get(i).getNumber());
            vo.setCompany(page.getResult().get(i).getCompany());
            switch ( page.getResult().get(i).getStatus().intValue()){
                case 0:
                    vo.setStatus("否");
                    break;
                case 1:
                    vo.setStatus("是");
                    break;

                    default:
                        vo.setStatus("否");

            }
            switch (page.getResult().get(i).getIntention().intValue()){
                case 0:
                    vo.setIntention("无购买意向");
                    break;
                case 1:
                    vo.setIntention("尚不清楚");
                    break;
                case 2:
                    vo.setIntention("有购买意向");
                    break;
                    default:
                        vo.setIntention("尚不清楚");
            }
            vo.setMoney(page.getResult().get(i).getMoney());
            try{
                page.getResult().get(i).getConnectId();
                vo.setConnectName(customerContactsMapper.selectByPrimaryKey(page.getResult().get(i).getConnectId()).getName());
                vo.setConnectId(page.getResult().get(i).getConnectId());
            }catch (NullPointerException a){
                System.out.println("联系人id没有");
            }

            //拿联系人id 去联系人表里找名字

            vo.setCompanyType(page.getResult().get(i).getCompanyType());
            vo.setScope(page.getResult().get(i).getScope());
            vo.setAddress(page.getResult().get(i).getAddress());
            vo.setCreateTime(page.getResult().get(i).getCreateTime());
            vo.setUpdateTime(page.getResult().get(i).getUpdateTime());


            customerSeaVo.add(i,vo);
            customerSeaVo.size();

        }

        CustomerSeaMapVo resultMap = new CustomerSeaMapVo();

        resultMap.setTotal(page.getTotal());
        resultMap.setData(customerSeaVo);
        return resultMap;
    }

}
