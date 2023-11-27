package com.enoca.springmvc.service;

import com.enoca.springmvc.dao.CustomerDAO;
import com.enoca.springmvc.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    public void saveCustomer(final Customer theCustomer) {
        customerDAO.saveCustomer(theCustomer);
    }
    @Override

    public Customer getCustomer(final Integer id) {
        return customerDAO.getCustomer(id);
    }


    @Override
    public void deleteCustomer(final Integer id) {
        customerDAO.deleteCustomer(id);
    }



}
