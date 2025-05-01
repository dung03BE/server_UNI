package com.dung.UniStore.repository;


import com.dung.UniStore.entity.ProductDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface IProductDetailsRepository extends JpaRepository<ProductDetails,Integer> {

    ProductDetails findByProductId(int id);

    @Modifying
    @Transactional
    @Query("DELETE FROM ProductDetails p WHERE p.product.id = :productId")
    void deleteByProductId(int productId);
}
