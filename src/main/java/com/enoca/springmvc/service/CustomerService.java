package com.enoca.springmvc.service;

import com.enoca.springmvc.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
    void saveCustomer (Customer theCustomer);

    Customer getCustomer(Integer id);

    void deleteCustomer(Integer id);
}
