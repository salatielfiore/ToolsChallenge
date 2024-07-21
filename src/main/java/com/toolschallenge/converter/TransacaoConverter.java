package com.toolschallenge.converter;

import com.toolschallenge.dto.response.TransacaoResponseDTO;
import com.toolschallenge.model.Transacao;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TransacaoConverter {

    private final ModelMapper modelMapper;

    public TransacaoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TransacaoResponseDTO toResponseDTO(Transacao transacao) {
        return modelMapper.map(transacao, TransacaoResponseDTO.class);
    }


}
