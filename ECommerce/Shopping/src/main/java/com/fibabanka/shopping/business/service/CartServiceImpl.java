package com.fibabanka.shopping.business.service;

import com.fibabanka.shopping.business.dto.CartDto;
import com.fibabanka.shopping.data.entity.Cart;
import com.fibabanka.shopping.data.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public long createCart(String customerName)
    {
        Cart cart = new Cart();
        cart.setCustomerName(customerName);
        cartRepository.save(cart);
        System.out.println(cartRepository.findTopByCartId());
        return cartRepository.findTopByCartId();
    }

    @Override
    public List<CartDto> findCart()
    {
        List<Cart> cartList = cartRepository.findByCart();
        List<CartDto> cartDtoList = new ArrayList<>();
        for (Cart cart : cartList) {
            CartDto cartDto = toDto(cart);
            cartDtoList.add(cartDto);
        }
        return cartDtoList;
    }

    @Override
    public void completeShopping(long cartId)
    {
        Cart cart = cartRepository.findCartByCartId(cartId);
        cart.setCartStatus(true);
        cartRepository.save(cart);
    }

    private CartDto toDto(Cart cart)
    {
        CartDto cartDto = new CartDto(cart.getCartId(), cart.getCustomerName());
        return cartDto;
    }
}
