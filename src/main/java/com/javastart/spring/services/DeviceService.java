package com.javastart.spring.services;

import com.javastart.spring.model.Category;
import com.javastart.spring.model.Device;
import com.javastart.spring.repositories.CategoryRepository;
import com.javastart.spring.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Scanner;

@Service
public class DeviceService {
    private DeviceRepository deviceRepository;
    private CategoryRepository categoryRepository;
    private Scanner scanner = new Scanner(System.in);

    public DeviceService(DeviceRepository deviceRepository,
                         CategoryRepository categoryRepository) {
        this.deviceRepository = deviceRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void addDevice() {
        Device deviceToAdd = new Device();
        System.out.println("Podaj nazwę urządzenia:");
        deviceToAdd.setName(scanner.nextLine());
        System.out.println("Podaj opis urządzenia:");
        deviceToAdd.setDescription(scanner.nextLine());
        System.out.println("Podaj ilość urządzeń w magazynie:");
        deviceToAdd.setQuantity(scanner.nextInt());
        System.out.println("Podaj cenę urządzenia:");
        deviceToAdd.setPrice(scanner.nextDouble());
        System.out.println("Podaj nazwę kategorii urządzenia:");
        String nameOfCategoryToAdd = scanner.nextLine();
        Optional<Category> categoryToAdd = categoryRepository.findCategoryByNameIgnoreCase(nameOfCategoryToAdd);
        if (categoryToAdd.isPresent()) {
            deviceToAdd.setCategory(categoryToAdd.get());
        } else {
            System.out.println("Brak kategorii o takim id");
            return;
        }
        deviceRepository.save(deviceToAdd);
        System.out.println("Dodano urządzenie: " + deviceToAdd.getName());
    }

    @Transactional
    public void removeDeviceById() {
        System.out.println("Podaj ID urządzenia do usunięcia:");
        Long idOfDeviceToRemove = scanner.nextLong();
        Optional<Device> deviceToRemove = deviceRepository.findById(idOfDeviceToRemove);
        if (deviceToRemove.isPresent()) {
            deviceRepository.deleteById(idOfDeviceToRemove);
            System.out.println("Usunięto urządzenie: " + deviceToRemove);
        } else System.out.println("Brak urządzenia o ID: " + idOfDeviceToRemove);
    }
}
