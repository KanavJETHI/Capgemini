package com.capg.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CustomerDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO Customer_withoutJPA VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                customer.getCustId(),
                customer.getName(),
                customer.getAddress());
    }

    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM Customer_withoutJPA";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Customer c = new Customer();
            c.setCustId(rs.getInt("CUSTOMERID"));
            c.setName(rs.getString("NAME"));
            c.setAddress(rs.getString("ADDRESS"));
            return c;
        });
    }

    public Customer findById(int id) {
        String sql = "SELECT * FROM Customer_withoutJPA WHERE CUSTOMERID=?";

        return jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                (rs, rowNum) -> {
                    Customer c = new Customer();
                    c.setCustId(rs.getInt("CUSTOMERID"));
                    c.setName(rs.getString("NAME"));
                    c.setAddress(rs.getString("ADDRESS"));
                    return c;
                });
    }

    public void updateCustomer(Customer customer) {
        String sql = "UPDATE Customer_withoutJPA SET NAME=?, ADDRESS=? WHERE CUSTOMERID=?";
        jdbcTemplate.update(sql,
                customer.getName(),
                customer.getAddress(),
                customer.getCustId());
    }

    public void deleteCustomer(int id) {
        String sql = "DELETE FROM Customer_withoutJPA WHERE CUSTOMERID=?";
        jdbcTemplate.update(sql, id);
    }
}