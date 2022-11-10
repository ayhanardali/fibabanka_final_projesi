package com.fibabanka.shopping.presentation.rest;

import com.fibabanka.shopping.business.dto.CartProductDto;
import com.fibabanka.shopping.business.service.CartProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartProductResource {

    private CartProductService cartProductService;

    public CartProductResource(CartProductService cartProductService) {
        this.cartProductService = cartProductService;
    }

    @PostMapping("/api/shopping/cart/add")
    public void add(CartProductDto cartProductDto)
    {
        cartProductService.addToCart(cartProductDto);
    }

    @GetMapping("/api/shopping/cart/getby")
    public List<CartProductDto> findCartProductsList()
    {
        return cartProductService.findCartProductsList();
    }

    @DeleteMapping("/api/shopping/cart/{cartId}/remove/{productId}")
    public void delete(@PathVariable("cartId") long cartId,
                       @PathVariable("productId") long productId)
    {
        cartProductService.deleteFromCart(cartId, productId);
    }
}
