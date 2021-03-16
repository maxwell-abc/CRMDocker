package com.ec.crm.mapper;

import com.ec.crm.bean.CustomerSeas;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerSeasMapper {

    List<CustomerSeas> getCustomerSea();
}
