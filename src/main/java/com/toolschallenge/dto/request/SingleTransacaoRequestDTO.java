package com.toolschallenge.dto.request;

/**
 * DTO (Data Transfer Object) para uma transação única.
 * <p>
 * Esta classe é utilizada para transferir dados de entrada relacionados a uma transação única.
 * Contém um único campo de transação do tipo {@link TransacaoRequestDTO}.
 *
 * @author Salatiel Fiore
 */
public class SingleTransacaoRequestDTO {

    TransacaoRequestDTO transacao;

    public TransacaoRequestDTO getTransacao() {
        return transacao;
    }

    public void setTransacao(TransacaoRequestDTO transacao) {
        this.transacao = transacao;
    }
}
