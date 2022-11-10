package com.fibabanka.inventory.data.repository;

import com.fibabanka.inventory.data.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("select p from Product p where p.productId = :productId")
    Product findProductByProductId(long productId);
    @Query("select p from Product p where p.category.categoryId = :categoryId")
    List<Product> findAllByCategoryId(long categoryId);
}
