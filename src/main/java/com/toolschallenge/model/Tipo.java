package com.toolschallenge.model;

import java.util.Optional;

public enum Tipo {

    AVISTA("AVISTA"),
    PARCELADO_LOJA("PARCELADO LOJA"),
    PARCELADO_EMISSOR("PARCELADO EMISSOR");

    final String value;

    Tipo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean sameOf(String value) {
        return this.value.equalsIgnoreCase(value);
    }

    public static Optional<Tipo> of(String mimeType) {
        for (Tipo tipo : values()) {
            if (tipo.sameOf(mimeType)) {
                return Optional.of(tipo);
            }
        }
        return Optional.empty();
    }
}
