package com.ec.crm.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;

@Data
@Qualifier
public class CustomerSeas {
    private int id;
    private String name;
}
