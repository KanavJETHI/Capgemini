package com.capg.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService cs;

    @PostMapping("/addcustomer")
    public int addCustomer(@RequestBody Customer customer) {
        cs.addCustomer(customer);
        return customer.getCustId();
    }

    @GetMapping("/allcustomers")
    public List<Customer> getAllCustomers() {
        return cs.getAllCustomers();
    }

    @GetMapping("/searchcustomer/{id}")
    public Customer findCustomerById(@PathVariable int id) {
        return cs.findByID(id);
    }

    @PutMapping("/updatecustomer")
    public Customer update(@RequestBody Customer customer) {
        cs.update(customer);
        return customer;
    }

    @DeleteMapping("/deletecustomer/{id}")
    public void deleteCustomer(@PathVariable int id) {
        cs.deleteCustomer(id);
    }
}