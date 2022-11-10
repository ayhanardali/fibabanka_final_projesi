package com.fibabanka.shopping.business.service;

import com.fibabanka.shopping.business.dto.CartProductDto;

import java.util.List;

public interface CartProductService {

    void addToCart(CartProductDto cartProductDto);

    List<CartProductDto> findCartProductsList();

    void deleteFromCart(long cartId, long productId);
}
