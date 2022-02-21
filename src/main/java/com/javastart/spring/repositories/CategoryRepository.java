package com.javastart.spring.repositories;

import com.javastart.spring.model.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

    @Transactional
    @Modifying
    @Override
    @Query("DELETE FROM Category c WHERE c.id = :id")
    void deleteById(Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Category c WHERE c = :categoryToRemove")
    void delete(Optional<Category> categoryToRemove);
}
