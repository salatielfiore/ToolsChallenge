package com.toolschallenge.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Descricao {

    private String valor;
    private LocalDateTime dataHora;
    private String estabelecimento;
    private String nsu;
    private String codigoAutorizacao;
    private Status status;

    public Descricao() {
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(String estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public String getNsu() {
        return nsu;
    }

    public void setNsu(String nsu) {
        this.nsu = nsu;
    }

    public String getCodigoAutorizacao() {
        return codigoAutorizacao;
    }

    public void setCodigoAutorizacao(String codigoAutorizacao) {
        this.codigoAutorizacao = codigoAutorizacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Descricao descricao = (Descricao) o;
        return Objects.equals(valor, descricao.valor) && Objects.equals(dataHora, descricao.dataHora) &&
                Objects.equals(estabelecimento, descricao.estabelecimento) && Objects.equals(nsu, descricao.nsu) &&
                Objects.equals(codigoAutorizacao, descricao.codigoAutorizacao) && status == descricao.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, dataHora, estabelecimento, nsu, codigoAutorizacao, status);
    }

    @Override
    public String toString() {
        return "Descricao{" +
                "valor='" + valor + '\'' +
                ", dataHora=" + dataHora +
                ", estabelecimento='" + estabelecimento + '\'' +
                ", nsu='" + nsu + '\'' +
                ", codigoAutorizacao='" + codigoAutorizacao + '\'' +
                ", status=" + status +
                '}';
    }
}
