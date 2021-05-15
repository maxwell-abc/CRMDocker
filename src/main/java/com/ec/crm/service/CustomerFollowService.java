package com.ec.crm.service;

import com.ec.common.db.fi.po.CustomerSeaSales;

public interface CustomerFollowService {
    int addFollow(CustomerSeaSales customerSeaSales);
    int deleteFollow(CustomerSeaSales customerSeaSales);
    int updateFollow(CustomerSeaSales customerSeaSales);
}
