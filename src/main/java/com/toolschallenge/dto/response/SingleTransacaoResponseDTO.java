package com.toolschallenge.dto.response;

/**
 * DTO (Data Transfer Object) para uma única transação.
 * <p>
 * Esta classe é utilizada para encapsular a resposta de uma única transação.
 * Contém um objeto {@link TransacaoResponseDTO} que representa os detalhes da transação.
 *
 * @author Salatiel Fiore
 */
public class SingleTransacaoResponseDTO {

    TransacaoResponseDTO transacao;

    public SingleTransacaoResponseDTO() {
    }

    public SingleTransacaoResponseDTO(TransacaoResponseDTO transacao) {
        this.transacao = transacao;
    }

    public TransacaoResponseDTO getTransacao() {
        return transacao;
    }

    public void setTransacao(TransacaoResponseDTO transacao) {
        this.transacao = transacao;
    }
}
