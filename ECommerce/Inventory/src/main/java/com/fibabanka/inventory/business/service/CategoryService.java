package com.fibabanka.inventory.business.service;

import com.fibabanka.inventory.business.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findByCategory();
}
