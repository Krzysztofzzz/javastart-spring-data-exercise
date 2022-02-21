package com.javastart.spring.services;

import com.javastart.spring.model.Customer;
import com.javastart.spring.model.Device;
import com.javastart.spring.repositories.CustomerRepository;
import com.javastart.spring.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Scanner;

@Service
public class RentService {

    private DeviceRepository deviceRepository;
    private CustomerRepository customerRepository;
    private Scanner scanner = new Scanner(System.in);

    public RentService(DeviceRepository deviceRepository,
                       CustomerRepository customerRepository) {
        this.deviceRepository = deviceRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void rentDevice() {
        System.out.println("Wpisz id urządzenia do wypożyczenia:");
        Long rentedDeviceId = scanner.nextLong();
        Optional<Device> deviceToRent = deviceRepository.findById(rentedDeviceId);
        if (deviceToRent.isEmpty()) {
            System.out.println("Brak urządzenia o id: " + rentedDeviceId);
            return;
        }
        System.out.println("Urządzenie: " + deviceToRent.get().getName());

        System.out.println("Wpisz id klienta który wypożycza:");
        Long rentingCustomerId = scanner.nextLong();
        Optional<Customer> rentingCustomer = customerRepository.findById(rentingCustomerId);
        if (rentingCustomer.isEmpty()) {
            System.out.println("Brak klienta o id: " + rentingCustomerId);
            return;
        }
        System.out.println("Klient: " + rentingCustomer.get().getFirstName() + " " + rentingCustomer.get().getLastName());

        deviceToRent.get().addCustomer(rentingCustomer.get());
        System.out.println("Wypożyczono urządzenie: " + deviceToRent.get().getName()
                + " dla klienta: " + rentingCustomer.get().getFirstName() + " " + rentingCustomer.get().getLastName());

    }

}
