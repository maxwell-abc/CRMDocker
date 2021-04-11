package com.ec.crm.bean.vo;

import com.ec.common.db.fi.po.CustomerSea;
import lombok.Data;

import java.util.List;

@Data
public class CustomerSeaMapVo {
    private List<CustomerSeaVo> data;
    private long total;
}
