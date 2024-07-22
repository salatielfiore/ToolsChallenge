package com.toolschallenge.repository;

import com.toolschallenge.model.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Repositório para gerenciar transações.
 *
 * @author Salatiel Fiore
 */
@Repository
public class TransacaoRepository {

    private static final Map<Long, Transacao> transacoes = new HashMap<>();

    /**
     * Realiza um pagamento.
     *
     * @param transacao a transação a ser realizada
     * @return a transação realizada
     */
    public Transacao realizarPagamento(Transacao transacao) {
        return salvar(transacao);
    }

    /**
     * Realiza um estorno.
     *
     * @param transacao a transação a ser estornada
     * @return a transação estornada
     */
    public Transacao realizarEstorno(Transacao transacao) {
        return salvar(transacao);
    }

    /**
     * Salva uma transação no repositório.
     *
     * @param transacao a transação a ser salva
     * @return a transação salva
     */
    private static Transacao salvar(Transacao transacao) {
        transacoes.put(transacao.getId(), transacao);
        return transacao;
    }

    /**
     * Lista todas as transações.
     *
     * @return uma lista de todas as transações
     */
    public List<Transacao> listarTransacoes() {
        return new ArrayList<>(transacoes.values());
    }

    /**
     * Busca uma transação por ID.
     *
     * @param id o ID da transação a ser buscada
     * @return um Optional contendo a transação, se encontrada
     */
    public Optional<Transacao> buscarTransacaoPorId(Long id) {
        Transacao value = transacoes.get(id);
        return value != null ? Optional.of(value) : Optional.empty();
    }

    /**
     * Adiciona uma transação de exemplo ao repositório.
     */
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
