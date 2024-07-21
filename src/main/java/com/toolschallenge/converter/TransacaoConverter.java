package com.toolschallenge.converter;

import com.toolschallenge.dto.response.TransacaoResponseDTO;
import com.toolschallenge.model.Transacao;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransacaoConverter {

    private final ModelMapper modelMapper;

    public TransacaoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TransacaoResponseDTO toResponseDTO(Transacao transacao) {
        return modelMapper.map(transacao, TransacaoResponseDTO.class);
    }

    public List<TransacaoResponseDTO> toListResponseDTO(List<Transacao> list) {
        return list.stream().map(this::toResponseDTO).toList();
    }


}
