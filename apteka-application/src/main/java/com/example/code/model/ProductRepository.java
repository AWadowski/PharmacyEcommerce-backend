package com.example.code.model;

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
public interface ProductRepository extends CrudRepository<Product, Long> {


    @Query("select id, name, price, description, typ, ingredients, pictureId from PRODUCT where ID = :id")
    Optional<Product> findByid(Long id);

    @Query("SELECT id, name, price, description, typ, ingredients, pictureId FROM PRODUCT WHERE DESCRIPTION IS NOT NULL")
    List<Product> findProductsByDescriptionNotNull();

    @Query("SELECT id, name, price, description, typ, ingredients, pictureId FROM PRODUCT WHERE PRICE BETWEEN :minPrice AND :maxPrice")
    List<Product> findProductsByPriceRange(double minPrice, double maxPrice);

    @Query("SELECT id, name, price, description, typ, ingredients, pictureId FROM PRODUCT WHERE NAME = :name")
    List<Product> findProductsByName(String name);

    @Query("SELECT id, name, price, description, typ, ingredients, pictureId FROM PRODUCT WHERE PRICE >= :price")
    List<Product> findProductsByPriceGreaterThanOrEqual(double price);

    @Query("SELECT id, name, price, description, typ, ingredients, pictureId FROM PRODUCT WHERE NAME LIKE %:name%")
    List<Product> findProductsByNameContaining(String name);

    @Query("SELECT id, name, price, description, typ, ingredients, pictureId FROM PRODUCT WHERE typ = :typProduktu")
    List<Product> findByTypProduktu(String typProduktu);


}
