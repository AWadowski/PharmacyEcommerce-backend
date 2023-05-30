package com.example.code.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author adam.wadowski
 * @since 24.05.2023
 */


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUCT")
@Entity(name = "PRODUCT")
public class Product {

    @Id
    @SequenceGenerator(name = "PRODUCT_ID_GENERATOR", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_ID_GENERATOR")
    private Long id;
    private String name;
    private double price;
    private String description;
    private String typ;
    private String ingredients;
    private Long picture_id;

}
