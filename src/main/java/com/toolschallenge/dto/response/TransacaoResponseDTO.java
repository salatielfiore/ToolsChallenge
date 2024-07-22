package com.toolschallenge.dto.response;

/**
 * DTO (Data Transfer Object) para a transação.
 * <p>
 * Esta classe é utilizada para transferir dados de resposta relacionados a uma transação.
 * Contém informações sobre a transação, incluindo o identificador, o cartão, a descrição e a forma de pagamento.
 *
 * @author Salatiel Fiore
 */
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
