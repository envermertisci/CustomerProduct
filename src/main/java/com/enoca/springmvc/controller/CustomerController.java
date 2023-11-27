package com.enoca.springmvc.controller;


import com.enoca.springmvc.entity.Customer;
import com.enoca.springmvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;



    @GetMapping("/list")
    public List<Customer> listCustomers(){
        List<Customer> customers = customerService.getCustomers();
        return customers ;
    }

    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer cus){
        customerService.saveCustomer(cus);
        return cus;
    }
    @PutMapping("/update/{id}")
    public Customer updateCustomer(@PathVariable(name="id") Integer id, @RequestBody Customer updatedCustomer){
        Customer customer = customerService.getCustomer(id);
        customer.setFirstName(updatedCustomer.getFirstName());
        customer.setLastName(updatedCustomer.getLastName());
        customerService.saveCustomer(customer);
        return customer;
    }
    @DeleteMapping("/delete/{id}")
    public List<Customer> deleteCustomer(@PathVariable(name = "id")Integer id){
        customerService.deleteCustomer(id);
        return customerService.getCustomers();
    }
}
