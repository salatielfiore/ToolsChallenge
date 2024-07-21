package com.toolschallenge;

import com.toolschallenge.model.*;
import com.toolschallenge.repository.TransacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TransacaoRepositoryTest {

    private TransacaoRepository transacaoRepository;
    private Transacao transacao;

    @BeforeEach
    void setUp() {
        transacaoRepository = new TransacaoRepository();
        transacao = new Transacao();
        transacao.setId(1L);
        transacao.setCartao("1234******1121");

        Descricao descricao = new Descricao();
        descricao.setValor("100.00");
        descricao.setDataHora(LocalDateTime.now());
        descricao.setEstabelecimento("Loja Exemplo");
        descricao.setNsu("123456");
        descricao.setCodigoAutorizacao("654321");
        descricao.setStatus(Status.AUTORIZADO);
        transacao.setDescricao(descricao);

        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setTipo(Tipo.AVISTA);
        formaPagamento.setParcelas("3");
        transacao.setFormaPagamento(formaPagamento);
    }

    @Test
    void testRealizarPagamento() {
        Transacao resultado = transacaoRepository.realizarPagamento(transacao);
        assertNotNull(resultado);
        assertEquals(transacao.getId(), resultado.getId());
    }

    @Test
    void testRealizarEstorno() {
        Transacao resultado = transacaoRepository.realizarEstorno(transacao);
        assertNotNull(resultado);
        assertEquals(transacao.getId(), resultado.getId());
    }

    @Test
    void testListarTransacoes() {
        transacaoRepository.realizarPagamento(transacao);
        assertFalse(transacaoRepository.listarTransacoes().isEmpty());
    }

    @Test
    void testBuscarTransacaoPorId() {
        transacaoRepository.realizarPagamento(transacao);
        Optional<Transacao> resultado = transacaoRepository.buscarTransacaoPorId(transacao.getId());
        assertTrue(resultado.isPresent());
        assertEquals(transacao.getId(), resultado.get().getId());
    }
}
