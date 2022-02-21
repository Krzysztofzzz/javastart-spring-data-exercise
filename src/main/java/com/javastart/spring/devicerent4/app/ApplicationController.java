package com.javastart.spring.devicerent4.app;


import com.javastart.spring.devicerent4.components.category.CategoryController;
import com.javastart.spring.devicerent4.components.customer.CustomerController;
import com.javastart.spring.devicerent4.components.device.DeviceController;
import com.javastart.spring.devicerent4.components.rent.RentController;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.Scanner;

@Controller
public class ApplicationController {

    private Scanner scanner = new Scanner(System.in);
    private DeviceController deviceController;
    private CategoryController categoryController;
    private CustomerController customerController;
    private RentController rentController;

    public ApplicationController(DeviceController deviceController, CategoryController categoryController,
                                 CustomerController customerController, RentController rentController) {
        this.deviceController = deviceController;
        this.categoryController = categoryController;
        this.customerController = customerController;
        this.rentController = rentController;
    }

    public void mainLoop() {
        Options option;
        do {
            printOptions();
            option = readOption();
            executeOption(option);
        } while(option != Options.EXIT);
    }

    private void printOptions() {
        System.out.println("Opcje:");
        Arrays.stream(Options.values()).forEach(System.out::println);
    }

    private Options readOption() {
        boolean correctOptionSelected = false;
        Options option = null;
        while(!correctOptionSelected) {
            System.out.println("Podaj ID opcji:");
            int optionId = scanner.nextInt();
            scanner.nextLine();
            try {
                option = Options.numberToCategory(optionId);
                correctOptionSelected = true;
            } catch(InvalidOptionException e) {
                System.err.println(e.getMessage());
            }
        }
        return option;
    }

    private void executeOption(Options option) {
        switch (option) {
            case ADD_DEVICE:
                deviceController.createDevice();
                break;
            case ADD_CATEGORY:
                categoryController.createCategory();
                break;
            case ADD_CUSTOMER:
                customerController.createCustomer();
                break;
            case RENT:
                rentController.rentDeviceToCustomer();
                break;
            case REMOVE_DEVICE:
                deviceController.removeDevice();
                break;
            case REMOVE_CATEGORY:
                categoryController.removeCategory();
                break;
            case REMOVE_CUSTOMER:
                customerController.removeCustomer();
                break;
            case EXIT:
                closeApp();
        }
    }

    private void closeApp() {
        scanner.close();
        System.out.println("Bye bye!");
    }
}