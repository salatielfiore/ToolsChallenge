package com.toolschallenge.converter;

import com.toolschallenge.dto.response.DescricaoResponseDTO;
import com.toolschallenge.model.Descricao;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DescricaoConverter {

    private final ModelMapper modelMapper;

    public DescricaoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DescricaoResponseDTO toResponseDTO(Descricao descricao) {
        return modelMapper.map(descricao, DescricaoResponseDTO.class);
    }


}
