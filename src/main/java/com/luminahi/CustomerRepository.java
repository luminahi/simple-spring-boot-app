package com.luminahi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Override
    default Customer getReferenceById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }
}
