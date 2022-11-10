package com.fibabanka.inventory.business.service;

import com.fibabanka.inventory.business.dto.ProductDto;
import com.fibabanka.inventory.data.entity.Product;
import com.fibabanka.inventory.data.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto find(long productId)
    {
        Product product = productRepository.findProductByProductId(productId);
        ProductDto productDto = toDto(product);
        return productDto;
    }

    @Override
    public List<ProductDto> findByCategoryId(long categoryId)
    {
        List<Product> productList = productRepository.findAllByCategoryId(categoryId);
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : productList) {
            ProductDto productDto = toDto(product);
            productDtoList.add(productDto);
        }
        return productDtoList;
    }

    private Product toEntity(ProductDto productDto)
    {
        return new Product(productDto.getProductId(), productDto.getProductName(), productDto.getSalesPrice(), productDto.getCategory());
    }

    private ProductDto toDto(Product product)
    {
        return new ProductDto(product.getProductId(), product.getProductName(), product.getSalesPrice(), product.getCategory());
    }
}
