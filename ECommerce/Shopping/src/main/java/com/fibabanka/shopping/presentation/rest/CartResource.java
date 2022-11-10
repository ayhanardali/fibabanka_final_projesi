package com.fibabanka.shopping.presentation.rest;

import com.fibabanka.shopping.business.dto.CartDto;
import com.fibabanka.shopping.business.service.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class CartResource {

    private CartService cartService;

    public CartResource(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/api/shopping/cart/create")
    public long create() {
        String customerName;
        customerName = getRandomName();
        return cartService.createCart(customerName);
    }

    @GetMapping("/api/shopping/cart/find")
    public List<CartDto> find()
    {
        List<CartDto> cartDtoList = cartService.findCart();
        return cartDtoList;
    }

    @GetMapping("/api/shopping/checkout/{cartId}")
    public void checkout(@PathVariable("cartId") long cartId)
    {
        cartService.completeShopping(cartId);
    }

    private String getRandomName()
    {
        Random random = new Random();
        String customerName = "";
        switch (random.nextInt(6)) {
            case 1:
                customerName = "Onder Teker";
                break;
            case 2:
                customerName = "Samet Altinay";
                break;
            case 3:
                customerName = "Ayhan Ardali";
                break;
            case 4:
                customerName = "Bilal Calar";
                break;
            case 5:
                customerName = "Selcuk Altinay";
                break;
        }
        return customerName;
    }
}
