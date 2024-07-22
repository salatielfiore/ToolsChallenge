package com.toolschallenge.dto.response;

import java.util.List;

/**
 * DTO (Data Transfer Object) para múltiplas transações.
 * <p>
 * Esta classe é utilizada para encapsular a resposta que contém uma lista de transações.
 * Permite retornar um conjunto de transações em uma única resposta.
 *
 * @author Salatiel Fiore
 */
public class MultipleTransacaoResponseDTO {

    private List<TransacaoResponseDTO> transacao;

    public MultipleTransacaoResponseDTO() {
    }

    public MultipleTransacaoResponseDTO(List<TransacaoResponseDTO> transacao) {
        this.transacao = transacao;
    }

    public List<TransacaoResponseDTO> getTransacao() {
        return transacao;
    }

    public void setTransacao(List<TransacaoResponseDTO> transacao) {
        this.transacao = transacao;
    }
}
