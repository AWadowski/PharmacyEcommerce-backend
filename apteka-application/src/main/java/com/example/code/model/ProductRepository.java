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


    @Query("select id, name, price, description, typ, ingredients, picture_id from PRODUCT where id = :id")
    Optional<Product> findByid(Long id);

    @Query("SELECT id, name, price, description, typ, ingredients, picture_id FROM PRODUCT WHERE description IS NOT NULL")
    List<Product> findProductsByDescriptionNotNull();

    @Query("SELECT id, name, price, description, typ, ingredients, picture_id FROM PRODUCT WHERE price BETWEEN :minPrice AND :maxPrice")
    List<Product> findProductsByPriceRange(double minPrice, double maxPrice);

    @Query("SELECT id, name, price, description, typ, ingredients, picture_id FROM PRODUCT WHERE name = :name")
    List<Product> findProductsByName(String name);

    @Query("SELECT id, name, price, description, typ, ingredients, picture_id FROM PRODUCT WHERE price >= :price")
    List<Product> findProductsByPriceGreaterThanOrEqual(double price);

    @Query("SELECT id, name, price, description, typ, ingredients, picture_id FROM PRODUCT WHERE name LIKE %:name%")
    List<Product> findProductsByNameContaining(String name);

    @Query("SELECT id, name, price, description, typ, ingredients, picture_id FROM PRODUCT WHERE typ = :typProduktu")
    List<Product> findByTypProduktu(String typProduktu);

}
