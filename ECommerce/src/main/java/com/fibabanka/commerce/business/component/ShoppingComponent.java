package com.fibabanka.commerce.business.component;

import com.fibabanka.shopping.business.dto.CartDto;
import com.fibabanka.shopping.business.dto.CartProductDto;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequestMapping("/shopping")
public class ShoppingComponent {

    @GetMapping("/cart/create")
    @ResponseBody
    public long create()
    {
        String url = "http://localhost:8082/api/shopping/cart/create/";
        RestTemplate restTemplate = new RestTemplate();
        long cartId = restTemplate.getForObject(url, Long.class);
        System.out.println("Create(ShoppingComponent) başarılı. cartId: " + cartId);
        return cartId;
    }

    @GetMapping("/cart/find/{cartId}")
    @ResponseBody
    public CartDto find(@PathVariable("cartId") long cartId)
    {
        String url = "http://localhost:8082/api/shopping/cart/find/" + cartId;
        RestTemplate restTemplate = new RestTemplate();
        CartDto cartDto = restTemplate.getForObject(url, CartDto.class);
        System.out.println("Find(ShoppingComponent) başarılı.");
        return cartDto;
    }

    @GetMapping("/checkout/{cartId}")
    @ResponseBody
    public void checkout(@PathVariable("cartId") long cartId)
    {
        String url = "http://localhost:8082/api/shopping/checkout/" + cartId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(url, Void.class);
        System.out.println("Checkout(ShoppingComponent) başarılı.");
    }

    @GetMapping("/cart/add")
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public void add(CartProductDto cartProductDto)
    {
        String url = "http://localhost:8082/api/shopping/cart/add";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(url, cartProductDto, CartProductDto.class);
        System.out.println("Add(ShoppingComponent) başarılı.");
    }

    @GetMapping("/cart/getby")
    @ResponseBody
    @Transactional
    public List<CartProductDto> findCartProductsList()
    {
        String url = "http://localhost:8082/api/shopping/cart/getby/";
        RestTemplate restTemplate = new RestTemplate();
        List<CartProductDto> cartProductDtoList = restTemplate.getForObject(url, List.class);
        System.out.println("FindCart başarılı.");
        return cartProductDtoList;
    }

    @GetMapping("/cart/{cartId}/remove/{productId}")
    @ResponseBody
    public void delete(@PathVariable("cartId") long cartId,
                       @PathVariable("productId") long productId)
    {
        String url = "http://localhost:8082/api/shopping/cart/" + cartId + "/remove/" + productId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);
        System.out.println("Delete(ShoppingComponent) başarılı.");
    }
}
