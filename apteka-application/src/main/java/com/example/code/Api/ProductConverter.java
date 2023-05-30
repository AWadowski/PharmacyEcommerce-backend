package com.example.code.Api;

import com.example.code.model.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * @author adam.wadowski
 * @since 24.05.2023
 */

@Component
public class ProductConverter implements Converter<Product, ProductApi> {

    public ProductApi fromEntity(Product entity){
        return ProductApi.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .typ(fromDisplayName(entity.getTyp()))
                .ingredients(entity.getIngredients())
                .pictureId(entity.getPicture_id())
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
                .picture_id(object.getPictureId())
                .build();
    }

    public TypProduktu fromDisplayName(String displayName) {
        for (TypProduktu typProduktu : TypProduktu.values()) {
            if (typProduktu.getDisplayName().equals(displayName)) {
                return typProduktu;
            }
        }
        throw new IllegalArgumentException("Invalid display name: " + displayName);
    }
    @Override
    public ProductApi convert(Product source) {
        return ProductApi.builder()
                .id(source.getId())
                .name(source.getName())
                .price(source.getPrice())
                .description(source.getDescription())
                .typ(fromDisplayName(source.getTyp()))
                .ingredients(source.getIngredients())
                .pictureId(source.getPicture_id())
                .build();
    }
}
