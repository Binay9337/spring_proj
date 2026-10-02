package com.example.methods_of_jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

/**
 * ProductRepository
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByProducName(String prodName);

    List<Product> findAllByProductPriceBetween(double startPrice, double endPrice);

    List<Product> findAllByProductPriceGreaterThanEqual(double price, Sort sort);

    Optional<Product> findByProducNameAndProducBrand(String name, String brand);

    // =========JPAQL======
    // @Query("SELECT p FROM Product p WHERE p.producName = ?1 AND p.producBrand =
    // ?2") // postional parameter
    // Optional<Product> getProductPositional(String name, String brand);

    @Query("SELECT p FROM Product p WHERE p.producName =:name AND p.producBrand =:brand") // named parameter
    Optional<Product> getProductNamed(String name, String brand);

    @Query(nativeQuery = true, value = "SELECT * FROM Product WHERE produc_Name = ? AND produc_brand")
    Optional<Product> getProductRawSql(String name, String brand);

    @Transactional // WHILE USING DML QUERY OR PERFOMING MULTIPLE DB OPERATION
    @Modifying // basically jpa/hibernet is set for DQL so we ahve to write this annotation to
               // use
    @Query(nativeQuery = true, value = "UPDATE product SET product_price=:price WHERE Product_id =:id")
    int updatePrice(int id, double price);
}