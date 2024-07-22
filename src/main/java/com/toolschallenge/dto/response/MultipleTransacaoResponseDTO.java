package com.toolschallenge.dto.response;

import java.util.List;

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
