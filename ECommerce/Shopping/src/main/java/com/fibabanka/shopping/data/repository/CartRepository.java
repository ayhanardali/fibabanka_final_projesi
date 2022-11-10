package com.fibabanka.shopping.data.repository;

import com.fibabanka.shopping.data.entity.Cart;
import com.fibabanka.shopping.data.entity.CartProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

    @Query("select c from Cart c where c.cartId = :cartId")
    Cart findCartByCartId(long cartId);

    @Query(value = "SELECT MAX(cart_id) FROM cart", nativeQuery = true)
    Long findTopByCartId();

    @Query("select c from Cart c")
    List<Cart> findByCart();
}
