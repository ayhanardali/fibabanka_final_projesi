package com.fibabanka.commerce.business.service;

import com.fibabanka.inventory.business.dto.CategoryDto;
import com.fibabanka.inventory.business.dto.ProductDto;
import com.fibabanka.shopping.business.dto.CartProductDto;

import java.util.List;

public interface CommerceService {

    List<CategoryDto> findByCategory();

    ProductDto find(long productId);

    List<ProductDto> findByCategoryId(long categoryId);

    long createCart();

    List<CartProductDto> findCartProducts();

    void completeShopping(long cartId);

    void addToCart(CartProductDto cartProductDto);

    void deleteFromCart(long cartId, long productId);
}
