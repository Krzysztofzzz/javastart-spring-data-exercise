package com.javastart.spring.devicerent4.components.category;

import com.javastart.spring.devicerent4.components.category.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
    Optional<Category> findByNameIgnoreCase(String name);
}
