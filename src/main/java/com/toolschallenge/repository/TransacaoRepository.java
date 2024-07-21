package com.toolschallenge.repository;

import com.toolschallenge.model.Transacao;
import org.springframework.stereotype.Component;

import java.util.*;

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

    public Optional<Transacao> buscarTransacaoPorId(Long id) {
        Transacao value = transacoes.get(id);
        return value != null ? Optional.of(value) : Optional.empty();
    }


}
