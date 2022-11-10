package com.fibabanka.shopping.business.dto;

import java.util.List;

public class CartDto {

    private long cartId;

    private String customerName;

    private List<CartProductDto> cartProductDtoList;

    public CartDto() {}

    public CartDto(long cartId, String customerName) {
        this.cartId = cartId;
        this.customerName = customerName;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
