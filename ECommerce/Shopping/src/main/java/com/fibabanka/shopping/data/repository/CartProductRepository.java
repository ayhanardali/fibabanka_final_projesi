package com.fibabanka.shopping.data.repository;

import com.fibabanka.shopping.data.entity.CartProduct;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartProductRepository extends CrudRepository<CartProduct, Long> {

    @Query("delete from CartProduct cp where cp.cart.cartId = :cartId and cp.productId = :productId")
    @Modifying
    void deleteCartProductsById(long cartId, long productId);

    List<CartProduct> findAllByCart_CartId(long cartId);

    @Query(value = "SELECT * FROM public.cart_product ORDER BY cart_id, product_id ASC", nativeQuery = true)
    List<CartProduct> findAllByCartIdAsc();
}
