package com.example.code.service;

import com.example.code.Api.ProductApi;
import com.example.code.Api.ProductConverter;
import com.example.code.Api.TypProduktu;
import com.example.code.model.Product;
import com.example.code.model.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author adam.wadowski
 * @since 24.05.2023
 */

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;


    public List<ProductApi> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productConverter::fromEntity)
                .toList();
    }

    public ProductApi getProductById(Long id) {
        return productConverter.fromEntity(productRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Product with id: " + id + " not found")));

    }

    public void addProduct(ProductApi productApi) {
        productRepository.save(productConverter.toEntity(productApi));
    }

    public void updateProduct(Long id, ProductApi updatedProductApi) {
        Product existingProduct = productRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Product with id: " + id + " not found"));
        Product newEntity = productConverter.toEntity(updatedProductApi);
        newEntity.setId(existingProduct.getId());
        productRepository.save(newEntity);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<ProductApi> findProductsByDescriptionNotNull() {
        return productRepository.findProductsByDescriptionNotNull().stream()
                .map(productConverter::fromEntity)
                .toList();
    }

    public List<ProductApi> findProductsByPriceRange(double minPrice, double maxPrice) {
        return productRepository.findProductsByPriceRange(minPrice, maxPrice).stream()
                .map(productConverter::fromEntity)
                .toList();
    }


    public List<ProductApi> findProductsByPriceGreaterThanOrEqual(double price) {
        return productRepository.findProductsByPriceGreaterThanOrEqual(price).stream()
                .map(productConverter::fromEntity)
                .toList();
    }

    public List<ProductApi> findProductsByNameContaining(String name) {
        return productRepository.findProductsByNameContaining(name).stream()
                .map(productConverter::fromEntity)
                .toList();
    }

    public List<ProductApi> findProductsByTypProduktu(TypProduktu typProduktu) {
        return productRepository.findByTypProduktu(typProduktu.name()).stream()
                .map(productConverter::fromEntity)
                .toList();
    }
}
