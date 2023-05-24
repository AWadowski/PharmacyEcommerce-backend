package com.example.code.Api;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author adam.wadowski
 * @since 24.05.2023
 */

@Data
@SuperBuilder
@RequiredArgsConstructor
public class ProductApi {

    private Long id;
    private String name;
    private double price;
    private String description;
    private TypProduktu typ;
    private String ingredients;
    private Long pictureId;

}
