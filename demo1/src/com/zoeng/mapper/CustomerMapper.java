package com.zoeng.mapper;

import com.zoeng.po.Customer;

/**
 * Created by Zoeng on 2021/4/4
 */
public interface CustomerMapper {
    public Customer findCustomerById(Integer id);
}
