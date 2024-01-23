package com.luminahi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customers")
public class MainController {
    
    private final CustomerRepository customerRepository;
    
    public MainController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    @GetMapping("/")
    public List<Customer> getAllCostumers() {
        return customerRepository.findAll();
    }
    
    @PostMapping("/")
    public void addCustomer(@RequestBody NewCustomerRequest body) {
        Customer customer = new Customer();
        customer.setName(body.name());
        customer.setAge(body.age());
        customer.setEmail(body.email());
        customerRepository.save(customer);
    }
    
    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int id) {  
        customerRepository.deleteById(id);
    }
    
    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable("customerId") int id, @RequestBody NewCustomerRequest body) {
        Customer existingCustomer = customerRepository.getReferenceById(id);
        if (body.email() != null)
            existingCustomer.setEmail(body.email());
        if (body.name() != null)
            existingCustomer.setName(body.name());
        if (body.age() != null)
            existingCustomer.setAge(body.age());
        customerRepository.save(existingCustomer);
    }
}
