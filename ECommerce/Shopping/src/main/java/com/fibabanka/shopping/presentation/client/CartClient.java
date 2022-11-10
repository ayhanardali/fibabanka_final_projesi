package com.fibabanka.shopping.presentation.client;

import com.fibabanka.shopping.business.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/shopping")
public class CartClient {

    @GetMapping("/cart/create")
    @ResponseBody
    public long create()
    {
        String url = "http://localhost:8082/api/shopping/cart/create/";
        RestTemplate restTemplate = new RestTemplate();
        long cartId = restTemplate.getForObject(url, Long.class);
        System.out.println("Create başarılı. cartId :" + cartId);
        return cartId;
    }

    @GetMapping("/cart/find")
    @ResponseBody
    public List<CartDto> find()
    {
        String url = "http://localhost:8082/api/shopping/cart/find/";
        RestTemplate restTemplate = new RestTemplate();
        List<CartDto> cartDtoList = restTemplate.getForObject(url, List.class);
        System.out.println("Find başarılı.");
        return cartDtoList;
    }

    @GetMapping("/checkout/{cartId}")
    @ResponseBody
    public void checkout(@PathVariable("cartId") long cartId)
    {
        String url = "http://localhost:8082/api/shopping/checkout/" + cartId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(url, Void.class);
        System.out.println("Checkout başarılı.");
    }
}
