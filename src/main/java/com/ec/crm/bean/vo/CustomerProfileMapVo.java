package com.ec.crm.bean.vo;

import com.ec.common.db.fi.po.CustomerProfile;
import lombok.Data;

import java.util.List;

@Data
public class CustomerProfileMapVo {

    private List<CustomerProfile> data;
    private long total;
}
