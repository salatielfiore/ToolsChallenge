package com.toolschallenge.converter;

import com.toolschallenge.dto.response.TransacaoResponseDTO;
import com.toolschallenge.model.Transacao;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Conversor para mapear objetos do tipo Transacao para TransacaoResponseDTO e vice-versa.
 * <p>
 * Esta classe utiliza o ModelMapper para realizar a conversão entre entidades e DTOs (Data Transfer Objects).
 *
 * @author Salatiel Fiore
 */
@Component
public class TransacaoConverter {

    private final ModelMapper modelMapper;

    /**
     * Construtor para injeção de dependências.
     *
     * @param modelMapper o ModelMapper usado para a conversão
     */
    public TransacaoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Converte uma transação para um DTO de resposta.
     *
     * @param transacao a transação a ser convertida
     * @return o DTO de resposta correspondente
     */
    public TransacaoResponseDTO toResponseDTO(Transacao transacao) {
        return modelMapper.map(transacao, TransacaoResponseDTO.class);
    }

    /**
     * Converte uma lista de transações para uma lista de DTOs de resposta.
     *
     * @param list a lista de transações a ser convertida
     * @return a lista de DTOs de resposta correspondente
     */
    public List<TransacaoResponseDTO> toListResponseDTO(List<Transacao> list) {
        return list.stream().map(this::toResponseDTO).toList();
    }
}
