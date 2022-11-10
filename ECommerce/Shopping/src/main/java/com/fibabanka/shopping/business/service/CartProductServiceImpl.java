package com.fibabanka.shopping.business.service;

import com.fibabanka.shopping.business.dto.CartProductDto;
import com.fibabanka.shopping.data.entity.CartProduct;
import com.fibabanka.shopping.data.repository.CartProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartProductServiceImpl implements CartProductService {

    private CartProductRepository cartProductRepository;

    public CartProductServiceImpl(CartProductRepository cartProductRepository) {
        this.cartProductRepository = cartProductRepository;
    }

    @Override
    public void addToCart(CartProductDto cartProductDto)
    {
        cartProductDto.setLineAmount(cartProductDto.getSalesPrice() * cartProductDto.getSalesQuantity());
        CartProduct cartProduct = toEntity(cartProductDto);
        cartProductRepository.save(cartProduct);
    }

    @Override
    public List<CartProductDto> findCartProductsList()
    {
        List<CartProduct> cartProductList = cartProductRepository.findAllByCartIdAsc();
        List<CartProductDto> cartProductDtoList = new ArrayList<>();
        for(CartProduct cartProduct : cartProductList){
            CartProductDto cartProductDto = toDto(cartProduct);
            cartProductDtoList.add(cartProductDto);
        }
        return cartProductDtoList;
    }

    @Transactional
    @Override
    public void deleteFromCart(long cartId, long productId)
    {
        cartProductRepository.deleteCartProductsById(cartId, productId);
    }

    private CartProduct toEntity(CartProductDto cartProductDto)
    {
        return new CartProduct(cartProductDto.getCartProductId(),
                cartProductDto.getProductId(),
                cartProductDto.getSalesQuantity(),
                cartProductDto.getSalesPrice(),
                cartProductDto.getLineAmount(),
                cartProductDto.getCart());
    }

    private CartProductDto toDto(CartProduct cartProduct)
    {
        return new CartProductDto(cartProduct.getCartProductId(),
                cartProduct.getProductId(),
                cartProduct.getSalesQuantity(),
                cartProduct.getSalesPrice(),
                cartProduct.getLineAmount(),
                cartProduct.getCart());
    }
}
