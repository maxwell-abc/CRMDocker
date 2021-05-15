package com.ec.crm.bean.vo;

import com.ec.common.db.fi.po.CustomerSeaSales;
import lombok.Data;

import java.util.List;

@Data
public class CustomerFollowMapVo {

    private List<CustomerSeaSales> data;
    private long total;

}
