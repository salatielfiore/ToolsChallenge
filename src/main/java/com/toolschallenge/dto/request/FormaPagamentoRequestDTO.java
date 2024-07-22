package com.toolschallenge.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.toolschallenge.deserializer.TipoDeserializer;
import com.toolschallenge.model.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO (Data Transfer Object) para o tipo de forma de pagamento.
 * <p>
 * Esta classe é utilizada para transferir dados de entrada relacionados à forma de pagamento.
 * Contém campos obrigatórios e suas validações, incluindo a deserialização personalizada para o tipo {@link Tipo}.
 *
 * @author Salatiel Fiore
 */
public class FormaPagamentoRequestDTO {

    @NotNull(message = "O tipo não pode ser nulo.")
    @JsonDeserialize(using = TipoDeserializer.class)
    private Tipo tipo;
    @NotNull(message = "As parcelas não pode ser nula.")
    @NotBlank(message = "As parcelas não pode ser vazia.")
    private String parcelas;

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

}
