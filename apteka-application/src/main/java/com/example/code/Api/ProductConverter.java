package com.example.code.Api;

import com.example.code.model.Product;
import org.springframework.stereotype.Component;

/**
 * @author adam.wadowski
 * @since 24.05.2023
 */

@Component
public class ProductConverter {

    public ProductApi fromEntity(Product entity){
        return ProductApi.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .typ(TypProduktu.valueOf(entity.getTyp()))
                .ingredients(entity.getIngredients())
                .pictureId(entity.getPictureId())
                .build();
    }

    public Product toEntity(ProductApi object){
        return Product.builder()
                .id(object.getId())
                .name(object.getName())
                .price(object.getPrice())
                .description(object.getDescription())
                .typ(object.getTyp().name())
                .ingredients(object.getIngredients())
                .pictureId(object.getPictureId())
                .build();
    }
}
