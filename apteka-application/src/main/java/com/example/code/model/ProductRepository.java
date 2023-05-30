package com.example.code.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author adam.wadowski
 * @since 24.05.2023
 */

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>, JpaRepository<Product, Long> {


    @Query("SELECT p FROM PRODUCT p where p.id = :id")
    Optional<Product> findByid(Long id);

    @Query("SELECT p FROM PRODUCT p WHERE p.description IS NOT NULL")
    List<Product> findProductsByDescriptionNotNull();

    @Query("SELECT p FROM PRODUCT p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<Product> findProductsByPriceRange(double minPrice, double maxPrice);

    @Query("SELECT p FROM PRODUCT p WHERE p.name = :name")
    List<Product> findProductsByName(String name);

    @Query("SELECT p FROM PRODUCT p WHERE p.price >= :price")
    List<Product> findProductsByPriceGreaterThanOrEqual(double price);

    @Query("SELECT p FROM PRODUCT p WHERE p.name LIKE %:name%")
    List<Product> findProductsByNameContaining(String name);

    @Query("SELECT p FROM PRODUCT p WHERE p.typ = :typProduktu")
    List<Product> findByTypProduktu(String typProduktu);

}
