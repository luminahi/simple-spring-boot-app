package com.luminahi;

import org.springframework.stereotype.Service;

@Service
public class MainService {
    private final CustomerRepository customerRepository;
        
    public MainService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }
}
