package com.toolschallenge.model;

import java.util.Objects;

public class FormaPagamento {

    private Tipo tipo;
    private String parcelas;

    public FormaPagamento() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormaPagamento that = (FormaPagamento) o;
        return tipo == that.tipo && Objects.equals(parcelas, that.parcelas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, parcelas);
    }

    @Override
    public String toString() {
        return "FormaPagamento{" +
                "tipo=" + tipo +
                ", parcelas='" + parcelas + '\'' +
                '}';
    }
}
