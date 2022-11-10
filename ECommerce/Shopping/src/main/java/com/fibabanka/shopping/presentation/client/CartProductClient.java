package com.fibabanka.shopping.presentation.client;

import com.fibabanka.shopping.business.dto.CartProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/shopping")
public class CartProductClient {

    @GetMapping("/cart/add")
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public CartProductDto add(CartProductDto cartProductDto)
    {
        String url = "http://localhost:8082/api/shopping/cart/add";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(url, cartProductDto, CartProductDto.class);
        System.out.println("Add başarılı.");
        return cartProductDto;
    }

    @GetMapping("/cart/getby")
    @ResponseBody
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
        System.out.println("Delete başarılı.");
    }
}
