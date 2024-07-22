package com.toolschallenge.config;

import com.toolschallenge.dto.response.FormaPagamentoResponseDTO;
import com.toolschallenge.model.FormaPagamento;
import com.toolschallenge.model.Tipo;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classe de configuração para o ModelMapper. Esta classe define a configuração necessária para utilizar o ModelMapper na aplicação.
 * <p>
 * O ModelMapper é uma biblioteca que facilita o mapeamento de objetos entre diferentes camadas da aplicação, como entidades e DTOs.
 *
 * @author Salatiel Fiore
 */
@Configuration
public class ModelMapperConfig {

    /**
     * Método para criar uma instância de ModelMapper.
     *
     * @return Uma instância de ModelMapper configurada.
     */
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Converter para Tipo -> String
        Converter<Tipo, String> tipoToStringConverter = context ->
                context.getSource() == null ? null : context.getSource().getValue();

        modelMapper.addConverter(tipoToStringConverter);

        // Configurar mapeamento personalizado
        modelMapper.addMappings(new PropertyMap<FormaPagamento, FormaPagamentoResponseDTO>() {
            @Override
            protected void configure() {
                using(tipoToStringConverter).map(source.getTipo()).setTipo(null);
            }
        });

        return modelMapper;
    }
}