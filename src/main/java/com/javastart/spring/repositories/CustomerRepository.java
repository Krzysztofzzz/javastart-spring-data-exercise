package com.javastart.spring.repositories;

import com.javastart.spring.model.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findCustomerByPeselNumber(String pesel);

    @Override
    @Modifying
    @Transactional
    @Query("DELETE FROM Customer c WHERE c.id = :id")
    void deleteById(Long id);
}