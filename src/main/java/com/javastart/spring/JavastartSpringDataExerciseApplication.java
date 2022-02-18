package com.javastart.spring;

import com.javastart.spring.controllers.ApplicationController;
import com.javastart.spring.model.Customer;
import com.javastart.spring.model.Category;
import com.javastart.spring.model.Device;
import com.javastart.spring.repositories.DeviceRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavastartSpringDataExerciseApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JavastartSpringDataExerciseApplication.class, args);
        ApplicationController applicationController = context.getBean(ApplicationController.class);
        DeviceRepository deviceRepository = context.getBean(DeviceRepository.class);



        Device device = new Device();
        device.setName("Wiertarka udarowa");
        device.setDescription("Wiertarka udarowa o dużej mocy 3000W z zestawem wierteł w komplecie");
        device.setPrice(80);
        device.setQuantity(5);

        Category category = new Category();
        category.setName("Elektronarzędzia");
        category.setDescription("Wiertarki, szlifierki, młoty udarowe i inne elektronarzędzia");

        Customer customer = new Customer();
        customer.setFirstName("Jan");
        customer.setLastName("Kowalski");
        customer.setPeselNumber("90908765123");
        customer.setPersonIDNumber("ABC678123");

        device.setCategory(category);
        device.addCustomer(customer);

        deviceRepository.save(device);

        applicationController.run();
    }

}
