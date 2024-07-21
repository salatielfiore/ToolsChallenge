package com.toolschallenge.repository;

import com.toolschallenge.exception.ValidateTransactionException;
import com.toolschallenge.model.Transacao;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TransacaoRepository {

    private static final Map<Long, Transacao> transacoes = new HashMap<>();


    public Transacao realizarPagamento(Transacao transacao) {
        Transacao transacaoMap = transacoes.get(transacao.getId());
        if (transacaoMap != null) {
            throw new ValidateTransactionException("Já existe uma transação cadastrada com esse id: " + transacao.getId());
        }
        transacoes.put(transacao.getId(), transacao);
        return transacao;
    }


}
