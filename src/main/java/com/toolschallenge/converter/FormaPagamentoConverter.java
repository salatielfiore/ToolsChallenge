package com.toolschallenge.converter;

import com.toolschallenge.dto.response.FormaPagamentoResponseDTO;
import com.toolschallenge.model.FormaPagamento;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FormaPagamentoConverter {

    private final ModelMapper modelMapper;

    public FormaPagamentoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public FormaPagamentoResponseDTO toResponseDTO(FormaPagamento formaPagamento) {
        return modelMapper.map(formaPagamento, FormaPagamentoResponseDTO.class);
    }


}
