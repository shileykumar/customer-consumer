package com.sunglowsys.service;

import com.sunglowsys.domain.Customer;

import java.util.List;

public interface CustomerService {

     void save(Customer customer);

     Customer get(Long id);

     List<Customer> getAll();

     void delete(Long id);
}
