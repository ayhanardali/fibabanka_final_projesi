package com.fibabanka.commerce.presentation.rest;

import com.fibabanka.commerce.business.service.CommerceService;
import com.fibabanka.inventory.business.dto.CategoryDto;
import com.fibabanka.inventory.business.dto.ProductDto;
import com.fibabanka.shopping.business.dto.CartProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommerceResource {

    private CommerceService commerceService;

    public CommerceResource(CommerceService commerceService) {
        this.commerceService = commerceService;
    }

    @GetMapping("/api/commerce/inventory/categories")
    public List<CategoryDto> getCategories()
    {
        return commerceService.findByCategory();
    }

    @GetMapping("/api/commerce/inventory/product/{id}")
    public ProductDto getProduct(@PathVariable("id") long productId)
    {
        return commerceService.find(productId);
    }

    @GetMapping("/api/commerce/inventory/products/{categoryId}")
    public List<ProductDto> getProducts(@PathVariable("categoryId") long categoryId)
    {
        return commerceService.findByCategoryId(categoryId);
    }

    @GetMapping("/api/commerce/shopping/cart/create")
    public long create()
    {
        return commerceService.createCart();
    }

    @GetMapping("/api/commerce/shopping/checkout/{cartId}")
    public void checkout(@PathVariable("cartId") long cartId)
    {
        commerceService.completeShopping(cartId);
    }

    @PostMapping("/api/commerce/shopping/cart/add")
    public void add(CartProductDto cartProductDto)
    {
        commerceService.addToCart(cartProductDto);
    }

    @GetMapping("/api/commerce/shopping/cart/find")
    public List<CartProductDto> findCarts()
    {
        return commerceService.findCartProducts();
    }

    @DeleteMapping("/api/commerce/shopping/cart/{cartId}/remove/{productId}")
    public void delete(@PathVariable("cartId") long cartId,
                       @PathVariable("productId") long productId)
    {
        commerceService.deleteFromCart(cartId, productId);
    }
}
