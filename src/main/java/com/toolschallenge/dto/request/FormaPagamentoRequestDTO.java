package com.toolschallenge.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.toolschallenge.deserializer.TipoDeserializer;
import com.toolschallenge.model.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FormaPagamentoRequestDTO {

    @NotNull(message = "O tipo não pode ser nulo.")
    @JsonDeserialize(using = TipoDeserializer.class)
    private Tipo tipo;
    @NotNull(message = "As parcelas não pode ser nula.")
    @NotBlank(message = "As parcelas não pode ser vazia.")
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
