package com.fibabanka.shopping.business.service;

import com.fibabanka.shopping.business.dto.CartDto;

import java.util.List;

public interface CartService {

    long createCart(String customerName);

    List<CartDto> findCart();

    void completeShopping(long cartId);
}
