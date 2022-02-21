package com.javastart.spring.devicerent4.components.rent;


import com.javastart.spring.devicerent4.components.customer.Customer;
import com.javastart.spring.devicerent4.components.customer.CustomerRepository;
import com.javastart.spring.devicerent4.components.device.Device;
import com.javastart.spring.devicerent4.components.device.DeviceRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Scanner;

@Service
public class RentController {

    private Scanner scanner = new Scanner(System.in);
    private DeviceRepository deviceRepository;
    private CustomerRepository customerRepository;

    public RentController(DeviceRepository deviceRepository, CustomerRepository customerRepository) {
        this.deviceRepository = deviceRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void rentDeviceToCustomer() {
        try {
            rent();
        } catch(RentException e) {
            System.err.println(e.getMessage());
        }
    }

    private void rent() {
        System.out.println("Podaj pesel klienta:");
        String pesel = scanner.nextLine();
        System.out.println("Podaj ID urządzenia:");
        long deviceId = scanner.nextLong();
        Optional<Customer> customer = customerRepository.findByPesel(pesel);
        Optional<Device> device = deviceRepository.findById(deviceId);
        if(customer.isPresent())
            device.ifPresentOrElse(dev -> {
                if(dev.getQuantity() > dev.getCustomers().size()) {
                    dev.addCustomer(customer.get());
                    System.out.println("Wypożyczono urządzenie.");
                } else
                    throw new RentException("Brak wolnych urządzeń o wskazanym ID");
            }, () -> {
                throw new RentException("Brak urządzenia o wskazanym ID");
            });
        else
            throw new RentException("Brak klienta o wskazanym peselu");
    }
}