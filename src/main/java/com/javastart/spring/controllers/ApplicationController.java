package com.javastart.spring.controllers;

import com.javastart.spring.model.Category;
import com.javastart.spring.model.Customer;
import com.javastart.spring.model.Device;
import com.javastart.spring.repositories.CategoryRepository;
import com.javastart.spring.repositories.CustomerRepository;
import com.javastart.spring.repositories.DeviceRepository;
import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.Scanner;

@Controller
public class ApplicationController {
    private int option = 0;
    private Scanner scanner = new Scanner(System.in);
    private DeviceRepository deviceRepository;
    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    public ApplicationController(DeviceRepository deviceRepository,
                                 CategoryRepository categoryRepository,
                                 CustomerRepository customerRepository) {
        this.deviceRepository = deviceRepository;
        this.customerRepository = customerRepository;
        this.categoryRepository = categoryRepository;
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
            case 1 -> addDevice();
            case 2 -> addCategory();
            case 3 -> addClient();

            case 5 -> removeDeviceById();
            // case 6 -> deleteCategoryById();
            //case 7 -> removeCustomerById();

            case 8 -> exit();
        }
    }

/*    private void removeCustomerById(){
        System.out.println("Podaj id klienta do usunięcia:");
        Long idOfCustomerToRemove = scanner.nextLong();
        customerRepository.deleteById(idOfCustomerToRemove);
        System.out.println("Usunięto klienta o id: " + idOfCustomerToRemove);

    }*/

    /*private void deleteCategoryById(){
        System.out.println("Podaj id kategorii do usunięcia:");
        Long idOfCategoryToDelete = scanner.nextLong();
        Optional<Category> categoryToDelete = categoryRepository.findById(idOfCategoryToDelete);
        if (categoryToDelete.isPresent()) {
            categoryRepository.deleteById(idOfCategoryToDelete);
            System.out.println("Usunięto kategorię o id: " + idOfCategoryToDelete);
        }else {
            System.out.println("Brak categorii o id: " + idOfCategoryToDelete);
        }
    }*/

    private void addClient() {
        Customer customerToAdd = new Customer();
        System.out.println("Podaj imię klienta:");
        scanner.nextLine();
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

    private void addCategory() {
        Category categoryToAdd = new Category();
        System.out.println("Podaj nazwę kategorii:");
        scanner.nextLine();
        categoryToAdd.setName(scanner.nextLine());
        System.out.println("Podaj opis kategorii");
        categoryToAdd.setDescription(scanner.nextLine());
        categoryRepository.save(categoryToAdd);
        System.out.println("Dodano kategorię: " + categoryToAdd.getName());
    }

    private void exit() {
        System.out.println("Koniec programu");
    }

    private void addDevice() {
        Device deviceToAdd = new Device();
        System.out.println("Podaj nazwę urządzenia:");
        scanner.nextLine();
        deviceToAdd.setName(scanner.nextLine());
        System.out.println("Podaj opis urządzenia:");
        deviceToAdd.setDescription(scanner.nextLine());
        System.out.println("Podaj ilość urządzeń w magazynie:");
        deviceToAdd.setQuantity(scanner.nextInt());
        System.out.println("Podaj cenę urządzenia:");
        deviceToAdd.setPrice(scanner.nextDouble());
        System.out.println("Podaj id kategorii urządzenia:");
        Long idOfCategoryToAdd = scanner.nextLong();
        Optional<Category> categoryToAdd = categoryRepository.findById(idOfCategoryToAdd);
        if (categoryToAdd.isPresent()) {
            deviceToAdd.setCategory(categoryToAdd.get());
        } else {
            System.out.println("Brak kategorii o takim id");
            return;
        }
        deviceRepository.save(deviceToAdd);
        System.out.println("Dodano urządzenie: " + deviceToAdd.getName());


    }

    private void removeDeviceById() {
        System.out.println("Podaj ID urządzenia do usunięcia:");
        Long idOfDeviceToRemove = scanner.nextLong();
        Optional<Device> deviceToRemove = deviceRepository.findById(idOfDeviceToRemove);
        if (deviceToRemove.isPresent()) {
            deviceRepository.deleteById(idOfDeviceToRemove);
            System.out.println("Usunięto urządzenie: " + deviceToRemove);
        } else System.out.println("Brak urządzenia o ID: " + idOfDeviceToRemove);
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
