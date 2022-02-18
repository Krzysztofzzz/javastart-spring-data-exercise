package com.javastart.spring.controllers;

import com.javastart.spring.model.Category;
import com.javastart.spring.model.Device;
import com.javastart.spring.repositories.CategoryRepository;
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

    public ApplicationController(DeviceRepository deviceRepository, CategoryRepository categoryRepository) {
        this.deviceRepository = deviceRepository;
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
            case 5 -> removeDeviceById();
            case 8 -> exit();
        }

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

        System.out.println("5 - Usuń urządzenie");

        System.out.println("8 - Koniec");

        System.out.println("Podaj Id opcji:");
    }
}
