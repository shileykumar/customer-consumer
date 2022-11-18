package com.sunglowsys.rest;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ConsumerController {
    private final Logger log = LoggerFactory.getLogger(ConsumerController.class);

    private final CustomerService customerService;

    public ConsumerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @StreamListener("input")
    @PostMapping("/save")
    public void saveCustomer(Customer customer) {
        log.info("Rest request to save Customer : {}", customer);
        customerService.save(new Customer(customer.getFirstName(), customer.getLastName(), customer.getMobile(), customer.getEmail()));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        log.info("Rest request to get Customer : {}", id);
        Customer result = customerService.get(id);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        log.info("Rest request to delete Customer : {}", id);
        customerService.delete(id);
        return ResponseEntity
                .ok()
                .build();
    }
}
