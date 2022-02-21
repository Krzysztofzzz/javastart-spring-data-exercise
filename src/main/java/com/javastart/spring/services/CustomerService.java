package com.javastart.spring.services;

import com.javastart.spring.model.Customer;
import com.javastart.spring.repositories.CustomerRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    private Scanner scanner = new Scanner(System.in);

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void addClient() {
        Customer customerToAdd = new Customer();
        System.out.println("Podaj imię klienta:");
        customerToAdd.setFirstName(scanner.nextLine());
        System.out.println("Podaj nazwisko klienta:");
        customerToAdd.setLastName(scanner.nextLine());
        System.out.println("Podaj numer PESEL klienta (max 11 znaków):");
        customerToAdd.setPeselNumber(scanner.nextLine());
        System.out.println("Podaj ID klienta (max 10 znaków):");
        customerToAdd.setPersonIDNumber(scanner.nextLine());
        customerRepository.save(customerToAdd);

        System.out.println("Dodano klienta: " + customerToAdd.getFirstName() + " " + customerToAdd.getLastName());

    }

    @Transactional
    public void removeCustomerById() {
        System.out.println("Podaj id klienta do usunięcia:");
        Long idOfCustomerToRemove = scanner.nextLong();
        Optional<Customer> customerToRemove = customerRepository.findById(idOfCustomerToRemove);
        if (customerToRemove.isPresent()){
            customerRepository.deleteById(idOfCustomerToRemove);
            System.out.println("Usunięto klienta o id: " + idOfCustomerToRemove);
        }else {
            System.out.println("Brak klienta o wskazanym id.");
        }
    }
}
