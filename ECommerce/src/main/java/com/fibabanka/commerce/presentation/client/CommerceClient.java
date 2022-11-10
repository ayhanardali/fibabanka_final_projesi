package com.fibabanka.commerce.presentation.client;

import com.fibabanka.inventory.business.dto.CategoryDto;
import com.fibabanka.inventory.business.dto.ProductDto;
import com.fibabanka.shopping.business.dto.CartProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/commerce")
public class CommerceClient {

    @GetMapping("/inventory/categories")
    @ResponseBody
    public List<CategoryDto> getCategories()
    {
        String url = "http://localhost:8080/api/commerce/inventory/categories/";
        RestTemplate restTemplate = new RestTemplate();
        List<CategoryDto> categoryDtoList = restTemplate.getForObject(url, List.class);
        System.out.println("getCategories(CommerceClient) başarılı.");
        return categoryDtoList;
    }

    @GetMapping("/inventory/product/{id}")
    @ResponseBody
    public ProductDto getProduct(@PathVariable("id") long productId)
    {
        String url = "http://localhost:8080/api/commerce/inventory/product/" + productId;
        RestTemplate restTemplate = new RestTemplate();
        ProductDto productDto = restTemplate.getForObject(url, ProductDto.class);
        System.out.println("getProduct(CommerceClient) başarılı.");
        return productDto;
    }

    @GetMapping("/inventory/products/{categoryId}")
    @ResponseBody
    public List<ProductDto> getProducts(@PathVariable("categoryId") long categoryId)
    {
        String url = "http://localhost:8080/api/commerce/inventory/products/" + categoryId;
        RestTemplate restTemplate = new RestTemplate();
        List<ProductDto> productDtoList = restTemplate.getForObject(url, List.class);
        System.out.println("getProducts(CommerceClient) başarılı.");
        return productDtoList;
    }

    @GetMapping("/shopping/cart/create")
    @ResponseBody
    public long create()
    {
        String url = "http://localhost:8080/api/commerce/shopping/cart/create/";
        RestTemplate restTemplate = new RestTemplate();
        long cartId = restTemplate.getForObject(url, Long.class);
        System.out.println("Create(CommerceClient) başarılı. cartId :" + cartId);
        return cartId;
    }

    @GetMapping("/shopping/checkout/{cartId}")
    @ResponseBody
    public void checkout(@PathVariable("cartId") long cartId)
    {
        String url = "http://localhost:8080/api/commerce/shopping/checkout/" + cartId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(url, Void.class);
        System.out.println("Checkout(CommerceClient) başarılı.");
    }

    @GetMapping("/shopping/cart/add")
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public void add(CartProductDto cartProductDto)
    {
        String url = "http://localhost:8080/api/commerce/shopping/cart/add";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(url, cartProductDto, CartProductDto.class);
        System.out.println("Add(CommerceClient) başarılı.");
    }

    @GetMapping("/shopping/cart/{cartId}/remove/{productId}")
    @ResponseBody
    public void delete(@PathVariable("cartId") long cartId,
                       @PathVariable("productId") long productId)
    {
        String url = "http://localhost:8080/api/commerce/shopping/cart/" + cartId + "/remove/" + productId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);
        System.out.println("Delete(CommerceClient) başarılı.");
    }

    @GetMapping("/shopping/cart/find")
    @ResponseBody
    public List<CartProductDto> findCartProductsList()
    {
        String url = "http://localhost:8080/api/commerce/shopping/cart/find";
        RestTemplate restTemplate = new RestTemplate();
        List<CartProductDto> cartProductDtoList = restTemplate.getForObject(url, List.class);
        System.out.println("FindCart başarılı.");
        return cartProductDtoList;
    }
}
