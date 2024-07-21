package com.toolschallenge.dto.response;

public class TransacaoResponseDTO {

    private Long id;
    private String cartao;
    private DescricaoResponseDTO descricao;
    private FormaPagamentoResponseDTO formaPagamento;

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

    public DescricaoResponseDTO getDescricao() {
        return descricao;
    }

    public void setDescricao(DescricaoResponseDTO descricao) {
        this.descricao = descricao;
    }

    public FormaPagamentoResponseDTO getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamentoResponseDTO formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
