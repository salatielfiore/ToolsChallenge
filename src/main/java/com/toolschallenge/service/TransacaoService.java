package com.toolschallenge.service;

import com.toolschallenge.converter.TransacaoConverter;
import com.toolschallenge.dto.request.TransacaoRequestDTO;
import com.toolschallenge.dto.response.TransacaoResponseDTO;
import com.toolschallenge.model.Descricao;
import com.toolschallenge.model.FormaPagamento;
import com.toolschallenge.model.Status;
import com.toolschallenge.model.Transacao;
import com.toolschallenge.repository.TransacaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final TransacaoConverter transacaoConverter;

    public TransacaoService(TransacaoRepository transacaoRepository, TransacaoConverter transacaoConverter) {
        this.transacaoRepository = transacaoRepository;
        this.transacaoConverter = transacaoConverter;
    }


    public List<TransacaoResponseDTO> listarTransacoes() {
        return transacaoConverter.toListResponseDTO(transacaoRepository.listarTransacoes());
    }

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

    public Descricao getDescricao(TransacaoRequestDTO dto) {
        Random random = new Random();
        Descricao descricao = new Descricao();
        BeanUtils.copyProperties(dto.getDescricao(), descricao);
        descricao.setNsu(String.valueOf(random.nextInt(1000, 10000)));
        descricao.setCodigoAutorizacao(String.valueOf(random.nextInt(1000, 10000)));
        descricao.setStatus(Status.AUTORIZADO);
        return descricao;
    }

    public FormaPagamento getFormaPagamento(TransacaoRequestDTO dto) {
        FormaPagamento formaPagamento = new FormaPagamento();
        BeanUtils.copyProperties(dto.getFormaPagamento(), formaPagamento);
        return formaPagamento;
    }


}
