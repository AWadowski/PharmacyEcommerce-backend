package com.example.code.Api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypProduktu {
    HEALTHWELLNESS("Zdrowie i uroda"),
    VITAMINS("Witaminy"),
    SUPPLEMENTS("Suplementy dietetyczne"),
    BEAUTY("Pielęgnacja ciała"),
    PHARMACY("Apteka");

    private final String displayName;
}