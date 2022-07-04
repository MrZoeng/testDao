package com.zoeng.test;

import com.zoeng.mapper.CustomerMapper;
import com.zoeng.po.Customer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Zoeng on 2021/4/4
 */

public class Daotest {
    @Test
    public void findCustomerByIdMapperTest(){
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerMapper customerMapper=act.getBean(CustomerMapper.class);
        Customer customer=customerMapper.findCustomerById(1);
        System.out.println(customer);
    }
}
