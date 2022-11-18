package com.sunglowsys.service;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final Logger log = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void save(Customer customer) {
        log.info("Request to save Customer : {}", customer);
        customerRepository.save(customer);
    }

    @Override
    public Customer get(Long id) {
        log.info("Request to get Customer : {}", id);
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> getAll() {
        log.info("Request to get Customers");
        return customerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        log.info("Request to delete Customer : {}", id);
        customerRepository.deleteById(id);
    }
}
