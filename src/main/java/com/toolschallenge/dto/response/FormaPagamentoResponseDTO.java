package com.toolschallenge.dto.response;

import com.toolschallenge.model.Tipo;

public class FormaPagamentoResponseDTO {

    private String tipo;
    private String parcelas;

    public FormaPagamentoResponseDTO() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

}
