package com.toolschallenge.dto.request;

public class TransacaoRequestDTO {

    private Long id;
    private String cartao;
    private DescricaoRequestDTO descricao;
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
