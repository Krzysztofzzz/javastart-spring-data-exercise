package com.javastart.spring.controllers;

import com.javastart.spring.enums.Options;
import com.javastart.spring.services.CategoryService;
import com.javastart.spring.services.CustomerService;
import com.javastart.spring.services.DeviceService;
import com.javastart.spring.services.RentService;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class ApplicationController {
    private Options option;
    private Scanner scanner = new Scanner(System.in);

    private DeviceService deviceService;
    private CategoryService categoryService;
    private CustomerService customerService;
    private RentService rentService;

    public ApplicationController(CategoryService categoryService,
                                 DeviceService deviceService,
                                 CustomerService customerService,
                                 RentService rentService) {
        this.categoryService = categoryService;
        this.deviceService = deviceService;
        this.customerService = customerService;
        this.rentService = rentService;
    }

    public void run() {
        do {
            printOptions();
            option = Options.chooseOption(scanner.nextInt());
            chooseOption(option);

        } while (!option.equals(Options.EXIT));
    }

    private void chooseOption(Options option) {
        switch (option) {
            case ADD_DEVICE -> deviceService.addDevice();
            case ADD_CATEGORY -> categoryService.addCategory();
            case ADD_CUSTOMER -> customerService.addClient();
            //case RENT_DEVICE -> rentService.rentDevice();
            case REMOVE_DEVICE -> deviceService.removeDeviceById();
            //case REMOVE_CATEGORY -> categoryService.deleteCategoryById();
            //case REMOVE_CUSTOMER -> customerService.removeCustomerById();
            case EXIT -> exit();
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
        System.out.println("4 - Wyporzycz urządzenie");
        System.out.println("5 - Usuń urządzenie");
        System.out.println("6 - Usuń kategorię");
        System.out.println("7 - Usuń klienta");
        System.out.println("8 - Koniec");

        System.out.println("Podaj Id opcji:");
    }
}
