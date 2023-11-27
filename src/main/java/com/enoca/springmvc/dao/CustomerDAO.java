package com.enoca.springmvc.dao;

import com.enoca.springmvc.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    void deleteCustomer(Integer id);

    void saveCustomer(Customer theCustomer);
    Customer getCustomer(Integer id);

}
