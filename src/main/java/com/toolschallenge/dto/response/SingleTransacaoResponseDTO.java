package com.toolschallenge.dto.response;

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
