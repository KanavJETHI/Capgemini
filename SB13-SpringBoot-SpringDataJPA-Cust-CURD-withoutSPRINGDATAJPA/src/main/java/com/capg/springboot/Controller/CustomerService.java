package com.capg.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerDAO dao;

    public void addCustomer(Customer customer) {
        dao.addCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return dao.getAllCustomers();
    }

    public Customer findByID(int id) {
        return dao.findById(id);
    }

    public void update(Customer customer) {
        dao.updateCustomer(customer);
    }

    public void deleteCustomer(int id) {
        dao.deleteCustomer(id);
    }
}