package com.fibabanka.inventory.data.repository;

import com.fibabanka.inventory.data.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query("select c from Category c")
    List<Category> findAllByCategory();
}
