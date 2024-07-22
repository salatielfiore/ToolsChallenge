package com.toolschallenge;

import com.toolschallenge.model.*;
import com.toolschallenge.repository.TransacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes unitários para o repositório {@link TransacaoRepository}.
 * <p>
 * Este conjunto de testes verifica o comportamento dos métodos do repositório {@link TransacaoRepository}.
 * O objetivo é garantir que os métodos de pagamento, estorno, listagem e busca por ID estejam funcionando corretamente.
 *
 * @author Salatiel Fiore
 */
class TransacaoRepositoryTest {

    private TransacaoRepository transacaoRepository;
    private Transacao transacao;

    /**
     * Configuração inicial dos testes. Cria uma instância do repositório e uma transação com dados de exemplo.
     */
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

    /**
     * Testa o método {@link TransacaoRepository#realizarPagamento(Transacao)}.
     * Verifica se o método realiza o pagamento corretamente e retorna a transação.
     */
    @Test
    void testRealizarPagamento() {
        Transacao resultado = transacaoRepository.realizarPagamento(transacao);
        assertNotNull(resultado);
        assertEquals(transacao.getId(), resultado.getId());
    }

    /**
     * Testa o método {@link TransacaoRepository#realizarEstorno(Transacao)}.
     * Verifica se o método realiza o estorno corretamente e retorna a transação.
     */
    @Test
    void testRealizarEstorno() {
        Transacao resultado = transacaoRepository.realizarEstorno(transacao);
        assertNotNull(resultado);
        assertEquals(transacao.getId(), resultado.getId());
    }

    /**
     * Testa o método {@link TransacaoRepository#listarTransacoes()}.
     * Verifica se o método lista as transações corretamente após realizar um pagamento.
     */
    @Test
    void testListarTransacoes() {
        transacaoRepository.realizarPagamento(transacao);
        assertFalse(transacaoRepository.listarTransacoes().isEmpty());
    }

    /**
     * Testa o método {@link TransacaoRepository#buscarTransacaoPorId(Long)}.
     * Verifica se o método busca uma transação pelo ID corretamente.
     */
    @Test
    void testBuscarTransacaoPorId() {
        transacaoRepository.realizarPagamento(transacao);
        Optional<Transacao> resultado = transacaoRepository.buscarTransacaoPorId(transacao.getId());
        assertTrue(resultado.isPresent());
        assertEquals(transacao.getId(), resultado.get().getId());
    }
}
