package com.javastart.spring.devicerent4.components.customer;

import com.javastart.spring.devicerent4.components.customer.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
