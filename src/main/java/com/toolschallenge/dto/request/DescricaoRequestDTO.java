package com.toolschallenge.dto.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

/**
 * DTO (Data Transfer Object) para a descrição de uma transação.
 * <p>
 * Esta classe é utilizada para transferir dados de entrada para a descrição de uma transação.
 * Contém campos obrigatórios e suas validações.
 *
 * @author Salatiel Fiore
 */
public class DescricaoRequestDTO {

    @NotNull(message = "O valor não pode ser nulo.")
    @NotBlank(message = "O valor não pode ser vazio.")
    private String valor;
    @NotNull(message = "A dataHora não pode ser nula.")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataHora;
    @NotNull(message = "O estabelecimento não pode ser nulo.")
    @NotBlank(message = "O estabelecimento não pode ser vazio.")
    private String estabelecimento;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(String estabelecimento) {
        this.estabelecimento = estabelecimento;
    }
}
