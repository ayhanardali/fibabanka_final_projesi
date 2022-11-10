package com.fibabanka.inventory.business.service;

import com.fibabanka.inventory.business.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto find(long productId);

    List<ProductDto> findByCategoryId(long categoryId);
}
