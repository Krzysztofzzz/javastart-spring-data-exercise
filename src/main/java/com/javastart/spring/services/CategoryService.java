package com.javastart.spring.services;

import com.javastart.spring.model.Category;
import com.javastart.spring.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private Scanner scanner = new Scanner(System.in);

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategory() {
        Category categoryToAdd = new Category();
        System.out.println("Podaj nazwę kategorii:");
        scanner.nextLine();
        categoryToAdd.setName(scanner.nextLine());
        System.out.println("Podaj opis kategorii");
        categoryToAdd.setDescription(scanner.nextLine());
        categoryRepository.save(categoryToAdd);
        System.out.println("Dodano kategorię: " + categoryToAdd.getName());
    }

/*        public void deleteCategoryById(){
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
}
