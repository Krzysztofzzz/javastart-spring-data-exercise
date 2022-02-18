package com.javastart.spring.controllers;

import com.javastart.spring.model.Device;
import com.javastart.spring.repositories.DeviceRepository;
import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.Scanner;

@Controller
public class ApplicationController {
    private int option = 0;
    private Scanner scanner = new Scanner(System.in);
    private DeviceRepository deviceRepository;

    public ApplicationController(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
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
            case 1:
                addDevice();
                break;
            case 5:
                removeDeviceById();
                break;

        }

    }

    private void addDevice() {

    }

    private void removeDeviceById() {
        System.out.println("Podaj ID urządzenia do usunięcia:");
        Long idOfDeviceToRemove = scanner.nextLong();
        Optional<Device> deviceToRemove = deviceRepository.findById(idOfDeviceToRemove);
        if (deviceToRemove.isPresent()) {
            deviceRepository.deleteById(idOfDeviceToRemove);
            System.out.println("Usunięto urządzenie: " + deviceToRemove);
        }else System.out.println("Brak urządzenia o ID: " + idOfDeviceToRemove);


    }

    private void printOptions() {
        System.out.println("Opcje:");
        System.out.println("1 - Dodaj urządzenie");

        System.out.println("5 - Usuń urządzenie");

        System.out.println("8 - Koniec");

        System.out.println("Podaj Id opcji:");
    }
}
