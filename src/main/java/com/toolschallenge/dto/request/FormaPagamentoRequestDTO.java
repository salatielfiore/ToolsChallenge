package com.toolschallenge.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.toolschallenge.model.Tipo;
import com.toolschallenge.deserializer.TipoDeserializer;

public class FormaPagamentoRequestDTO {

    @JsonDeserialize(using = TipoDeserializer.class)
    private Tipo tipo;
    private String parcelas;

    public FormaPagamentoRequestDTO() {
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

}
