package com.ec.crm.service;

import com.ec.common.db.fi.po.CustomerMySale;
import com.ec.common.db.fi.po.CustomerSaleView;
import com.ec.crm.bean.vo.CustomerSaleMapVo;


import java.util.List;

public interface CustomerSaleService {


    CustomerSaleMapVo selectByType(CustomerSaleView customerSaleView);

}
