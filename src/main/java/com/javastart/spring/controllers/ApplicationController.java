package com.javastart.spring.controllers;

import com.javastart.spring.services.CategoryService;
import com.javastart.spring.services.CustomerService;
import com.javastart.spring.services.DeviceService;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class ApplicationController {
    private int option = 0;
    private Scanner scanner = new Scanner(System.in);

    private DeviceService deviceService;
    private CategoryService categoryService;
    private CustomerService customerService;

    public ApplicationController(CategoryService categoryService,
                                 DeviceService deviceService,
                                 CustomerService customerService) {
        this.categoryService = categoryService;
        this.deviceService = deviceService;
        this.customerService = customerService;
    }

    public void run() {
        do {
            printOptions();
            option = scanner.nextInt();
            chooseOption(option);
        } while (option != 8);
    }

    private void chooseOption(int option) {
        switch (option) {
            case 1 -> deviceService.addDevice();
            case 2 -> categoryService.addCategory();
            case 3 -> customerService.addClient();

            case 5 -> deviceService.removeDeviceById();
            // case 6 -> deleteCategoryById();
            //case 7 -> removeCustomerById();

            case 8 -> exit();
        }
    }

    private void exit() {
        System.out.println("Koniec programu");
    }

    private void printOptions() {
        System.out.println("Opcje:");
        System.out.println("1 - Dodaj urządzenie");
        System.out.println("2 - Dodaj kategorię");
        System.out.println("3 - Dodaj clienta");

        System.out.println("5 - Usuń urządzenie");
        System.out.println("6 - Usuń kategorię");
        System.out.println("7 - Usuń klienta");
        System.out.println("8 - Koniec");

        System.out.println("Podaj Id opcji:");
    }
}
