package com.toolschallenge.model;

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
}
