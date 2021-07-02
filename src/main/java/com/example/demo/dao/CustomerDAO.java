package com.example.demo.dao;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();

  public  void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
