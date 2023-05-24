package com.example.code.Api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypProduktu {
    LEK("Lek"),
    WITAMINA("Witamina"),
    SUPLEMENT_DIETETYCZNY("Suplement dietetyczny");

    private final String displayName;
}