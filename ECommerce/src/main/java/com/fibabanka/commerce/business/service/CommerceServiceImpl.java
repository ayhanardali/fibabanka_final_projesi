package com.fibabanka.commerce.business.service;

import com.fibabanka.commerce.business.component.InventoryComponent;
import com.fibabanka.commerce.business.component.ShoppingComponent;
import com.fibabanka.inventory.business.dto.CategoryDto;
import com.fibabanka.inventory.business.dto.ProductDto;
import com.fibabanka.shopping.business.dto.CartProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommerceServiceImpl implements CommerceService {

    private InventoryComponent inventoryComponent;

    private ShoppingComponent shoppingComponent;

    public CommerceServiceImpl(InventoryComponent inventoryComponent, ShoppingComponent shoppingComponent) {
        this.inventoryComponent = inventoryComponent;
        this.shoppingComponent = shoppingComponent;
    }

    @Override
    public List<CategoryDto> findByCategory()
    {
        return inventoryComponent.getCategories();
    }

    @Override
    public ProductDto find(long productId)
    {
        return inventoryComponent.getProduct(productId);
    }

    @Override
    public List<ProductDto> findByCategoryId(long categoryId)
    {
        return inventoryComponent.getProducts(categoryId);
    }

    @Override
    public long createCart()
    {
        return shoppingComponent.create();
    }

    @Override
    public List<CartProductDto> findCartProducts()
    {
        return shoppingComponent.findCartProductsList();
    }

    @Override
    public void completeShopping(long cartId)
    {
        shoppingComponent.checkout(cartId);
    }

    @Override
    public void addToCart(CartProductDto cartProductDto)
    {
        shoppingComponent.add(cartProductDto);
    }

    @Override
    public void deleteFromCart(long cartId, long productId)
    {
        shoppingComponent.delete(cartId,productId);
    }
}
