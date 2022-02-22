package com.javastart.spring.services;

import com.javastart.spring.model.Category;
import com.javastart.spring.repositories.CategoryRepository;
import com.javastart.spring.repositories.DeviceRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private DeviceRepository deviceRepository;
    private Scanner scanner;

    public CategoryService(CategoryRepository categoryRepository, Scanner scanner, DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
        this.scanner = scanner;
        this.categoryRepository = categoryRepository;
    }

    public void addCategory() {
        Category categoryToAdd = new Category();
        System.out.println("Podaj nazwę kategorii:");
        categoryToAdd.setName(scanner.nextLine());
        System.out.println("Podaj opis kategorii");
        categoryToAdd.setDescription(scanner.nextLine());
        categoryRepository.save(categoryToAdd);
        System.out.println("Dodano kategorię: " + categoryToAdd.getName());
    }

    public void removeCategoryById() {
        System.out.println("Podaj id kategorii do usunięcia:");
        Long idOfCategoryToDelete = scanner.nextLong();
        Optional<Category> categoryToRemove = categoryRepository.findById(idOfCategoryToDelete);
        if (categoryToRemove.isPresent()) {
            deviceRepository.deleteAllDevicesByCategoryId(idOfCategoryToDelete);
            categoryRepository.deleteById(idOfCategoryToDelete);
            System.out.println("Usunięto kategorię o id: " + idOfCategoryToDelete);
        } else {
            System.out.println("Brak categorii o id: " + idOfCategoryToDelete);
        }
    }
}
