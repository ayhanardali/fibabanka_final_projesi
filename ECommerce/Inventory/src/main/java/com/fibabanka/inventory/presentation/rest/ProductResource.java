package com.fibabanka.inventory.presentation.rest;

import com.fibabanka.inventory.business.dto.ProductDto;
import com.fibabanka.inventory.business.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductResource {

    private ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/inventory/product/{id}")
    public ProductDto getProduct(@PathVariable("id") long productId)
    {
        return productService.find(productId);
    }

    @GetMapping("/api/inventory/products/{categoryId}")
    public List<ProductDto> getProducts(@PathVariable("categoryId") long categoryId)
    {
        return productService.findByCategoryId(categoryId);
    }
}
