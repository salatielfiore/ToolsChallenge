package com.toolschallenge.model;

import java.util.Objects;

public class Transacao {

    private Long id;
    private String cartao;
    private Descricao descricao;
    private FormaPagamento formaPagamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public Descricao getDescricao() {
        return descricao;
    }

    public void setDescricao(Descricao descricao) {
        this.descricao = descricao;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transacao transacao = (Transacao) o;
        return Objects.equals(id, transacao.id) && Objects.equals(cartao, transacao.cartao) && Objects.equals(descricao, transacao.descricao) && Objects.equals(formaPagamento, transacao.formaPagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cartao, descricao, formaPagamento);
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", cartao='" + cartao + '\'' +
                ", descricao=" + descricao +
                ", formaPagamento=" + formaPagamento +
                '}';
    }
}
