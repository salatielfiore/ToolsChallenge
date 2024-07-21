package com.toolschallenge.repository;

import com.toolschallenge.exception.ValidateTransactionException;
import com.toolschallenge.model.Transacao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TransacaoRepository {

    private static final Map<Long, Transacao> transacoes = new HashMap<>();


    public Transacao realizarPagamento(Transacao transacao) {
        transacoes.put(transacao.getId(), transacao);
        return transacao;
    }

    public List<Transacao> listarTransacoes() {
        return new ArrayList<>(transacoes.values());
    }


}
