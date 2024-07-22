package com.toolschallenge.service;

import com.toolschallenge.converter.TransacaoConverter;
import com.toolschallenge.dto.request.TransacaoRequestDTO;
import com.toolschallenge.dto.response.TransacaoResponseDTO;
import com.toolschallenge.exception.NotFoundTransactionException;
import com.toolschallenge.exception.ValidateTransactionException;
import com.toolschallenge.model.Descricao;
import com.toolschallenge.model.FormaPagamento;
import com.toolschallenge.model.Status;
import com.toolschallenge.model.Transacao;
import com.toolschallenge.repository.TransacaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Serviço para gerenciar transações.
 *
 * @author Salatiel Fiore
 */
@Service
public class TransacaoService {

    private static final Random RANDOM = new Random();

    private final TransacaoRepository transacaoRepository;
    private final TransacaoConverter transacaoConverter;

    /**
     * Construtor para injeção de dependências.
     *
     * @param transacaoRepository o repositório de transações
     * @param transacaoConverter  o conversor de transações
     */
    public TransacaoService(TransacaoRepository transacaoRepository, TransacaoConverter transacaoConverter) {
        this.transacaoRepository = transacaoRepository;
        this.transacaoConverter = transacaoConverter;
    }

    /**
     * Busca uma transação por ID.
     *
     * @param id o ID da transação
     * @return o DTO de resposta da transação
     */
    public TransacaoResponseDTO buscarTransacaoPorId(Long id) {
        Transacao transacao = getTransacao(id);
        return transacaoConverter.toResponseDTO(transacao);
    }

    /**
     * Obtém uma transação por ID, lançando uma exceção se não for encontrada.
     *
     * @param id o ID da transação
     * @return a transação
     * @throws NotFoundTransactionException se a transação não for encontrada
     */
    private Transacao getTransacao(Long id) {
        return transacaoRepository.buscarTransacaoPorId(id).orElseThrow(() ->
                new NotFoundTransactionException("nenhuma transação encontrado para o id " + id));
    }

    /**
     * Lista todas as transações.
     *
     * @return uma lista de DTOs de resposta de transações
     */
    public List<TransacaoResponseDTO> listarTransacoes() {
        return transacaoConverter.toListResponseDTO(transacaoRepository.listarTransacoes());
    }

    /**
     * Realiza um estorno de uma transação.
     *
     * @param id o ID da transação a ser estornada
     * @return o DTO de resposta da transação estornada
     * @throws ValidateTransactionException se a transação já foi estornada
     */
    public TransacaoResponseDTO realizarEstorno(Long id) {
        Transacao transacao = getTransacao(id);
        if (transacao.getDescricao().getStatus().equals(Status.CANCELADO)) {
            throw new ValidateTransactionException("A transação já foi estornada.");
        }
        transacao.getDescricao().setStatus(Status.CANCELADO);
        transacao = transacaoRepository.realizarEstorno(transacao);
        return transacaoConverter.toResponseDTO(transacao);
    }

    /**
     * Realiza um pagamento.
     *
     * @param dto o DTO de requisição de transação
     * @return o DTO de resposta da transação realizada
     */
    public TransacaoResponseDTO realizarPagamento(TransacaoRequestDTO dto) {
        Transacao transacao = new Transacao();
        BeanUtils.copyProperties(dto, transacao);
        Descricao descricao = getDescricao(dto);
        FormaPagamento formaPagamento = getFormaPagamento(dto);
        transacao.setDescricao(descricao);
        transacao.setFormaPagamento(formaPagamento);
        transacao = transacaoRepository.realizarPagamento(transacao);

        return transacaoConverter.toResponseDTO(transacao);
    }

    /**
     * Obtém a descrição de uma transação a partir de um DTO de requisição.
     *
     * @param dto o DTO de requisição de transação
     * @return a descrição da transação
     */
    public Descricao getDescricao(TransacaoRequestDTO dto) {
        Descricao descricao = new Descricao();
        BeanUtils.copyProperties(dto.getDescricao(), descricao);
        descricao.setNsu(String.valueOf(RANDOM.nextInt(1000, 10000)));
        descricao.setCodigoAutorizacao(String.valueOf(RANDOM.nextInt(1000, 10000)));
        descricao.setStatus(Status.AUTORIZADO);
        return descricao;
    }

    /**
     * Obtém a forma de pagamento de uma transação a partir de um DTO de requisição.
     *
     * @param dto o DTO de requisição de transação
     * @return a forma de pagamento
     */
    public FormaPagamento getFormaPagamento(TransacaoRequestDTO dto) {
        FormaPagamento formaPagamento = new FormaPagamento();
        BeanUtils.copyProperties(dto.getFormaPagamento(), formaPagamento);
        return formaPagamento;
    }

}
