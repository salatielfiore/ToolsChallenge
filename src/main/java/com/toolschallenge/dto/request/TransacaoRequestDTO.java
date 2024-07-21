package com.toolschallenge.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TransacaoRequestDTO {

    @NotNull(message = "O id não pode ser nulo")
    private Long id;
    @NotNull(message = "O cartao não pode ser nulo.")
    @NotBlank(message = "O cartao não pode ser vazio.")
    private String cartao;
    @Valid
    private DescricaoRequestDTO descricao;
    @Valid
    private FormaPagamentoRequestDTO formaPagamento;

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

    public DescricaoRequestDTO getDescricao() {
        return descricao;
    }

    public void setDescricao(DescricaoRequestDTO descricao) {
        this.descricao = descricao;
    }

    public FormaPagamentoRequestDTO getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamentoRequestDTO formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
