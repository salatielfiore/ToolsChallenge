package com.toolschallenge.dto.request;

import com.toolschallenge.dto.response.TransacaoResponseDTO;

public class SingleTransacaoRequestDTO {

    TransacaoRequestDTO transacao;

    public TransacaoRequestDTO getTransacao() {
        return transacao;
    }

    public void setTransacao(TransacaoRequestDTO transacao) {
        this.transacao = transacao;
    }
}
