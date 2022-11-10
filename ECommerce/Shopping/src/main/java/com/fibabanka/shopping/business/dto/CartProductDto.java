package com.fibabanka.shopping.business.dto;

import com.fibabanka.shopping.data.entity.Cart;

public class CartProductDto {

    private long cartProductId;

    private long productId;

    private long salesQuantity;

    private double salesPrice;

    private double lineAmount;

    private Cart cart;

    public CartProductDto() {}

    public CartProductDto(long cartProductId, long productId, long salesQuantity, double salesPrice, double lineAmount, Cart cart) {
        this.cartProductId = cartProductId;
        this.productId = productId;
        this.salesQuantity = salesQuantity;
        this.salesPrice = salesPrice;
        this.lineAmount = lineAmount;
        this.cart = cart;
    }

    public long getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(long cartProductId) {
        this.cartProductId = cartProductId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(long salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public double getLineAmount() {
        return this.salesPrice * this.salesQuantity;
    }

    public void setLineAmount(double lineAmount) {
        this.lineAmount = lineAmount;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
