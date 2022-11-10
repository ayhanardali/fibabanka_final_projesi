package com.fibabanka.inventory.presentation.client;

import com.fibabanka.inventory.business.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/inventory")
public class ProductClient {

    @GetMapping("/product/{id}")
    @ResponseBody
    public ProductDto getProduct(@PathVariable("id") long productId)
    {
        String url = "http://localhost:8081/api/inventory/product/" + productId;
        RestTemplate restTemplate = new RestTemplate();
        ProductDto productDto = restTemplate.getForObject(url, ProductDto.class);
        System.out.println("getForObject(Product with productId) başarılı.");
        return productDto;
    }

    @GetMapping("/products/{categoryId}")
    @ResponseBody
    public List<ProductDto> getProducts(@PathVariable("categoryId") long categoryId)
    {
        String url = "http://localhost:8081/api/inventory/products/" + categoryId;
        RestTemplate restTemplate = new RestTemplate();
        List<ProductDto> productDtoList = restTemplate.getForObject(url, List.class);
        System.out.println("getForObject(Products by categoryId) başarılı.");
        return productDtoList;
    }

}
