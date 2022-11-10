package com.fibabanka.inventory.business.service;

import com.fibabanka.inventory.business.dto.CategoryDto;
import com.fibabanka.inventory.data.entity.Category;
import com.fibabanka.inventory.data.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> findByCategory()
    {
        List<Category> categoryList = categoryRepository.findAllByCategory();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for  (Category category : categoryList) {
            CategoryDto categoryDto = toDto(category);
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }

    private Category toEntity(CategoryDto categoryDto)
    {
        return new Category(categoryDto.getCategoryId(), categoryDto.getCategoryName());
    }

    private CategoryDto toDto(Category category)
    {
        return new CategoryDto(category.getCategoryId(), category.getCategoryName());
    }
}
