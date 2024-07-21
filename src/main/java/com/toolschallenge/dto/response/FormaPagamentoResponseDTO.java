package com.toolschallenge.dto.response;

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
