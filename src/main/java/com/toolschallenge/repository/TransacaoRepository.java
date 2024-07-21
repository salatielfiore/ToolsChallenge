package com.toolschallenge.repository;

import com.toolschallenge.model.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class TransacaoRepository {

    private static final Map<Long, Transacao> transacoes = new HashMap<>();


    public Transacao realizarPagamento(Transacao transacao) {
        return salvar(transacao);
    }

    public Transacao realizarEstorno(Transacao transacao) {
        return salvar(transacao);
    }

    private static Transacao salvar(Transacao transacao) {
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

    public void adicionarTransacao() {
        Descricao descricao = new Descricao();
        descricao.setValor("155.23");
        descricao.setDataHora(LocalDateTime.now());
        descricao.setEstabelecimento("Novo Horizonte");
        descricao.setNsu("12456");
        descricao.setCodigoAutorizacao("544343");
        descricao.setStatus(Status.AUTORIZADO);

        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setTipo(Tipo.AVISTA);
        formaPagamento.setParcelas("4");

        Transacao transacao = new Transacao();
        transacao.setId(948349L);
        transacao.setCartao("54545******43434");
        transacao.setDescricao(descricao);
        transacao.setFormaPagamento(formaPagamento);
        transacoes.put(transacao.getId(), transacao);
    }


}
