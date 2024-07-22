package com.toolschallenge.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.toolschallenge.exception.ValidateTransactionException;
import com.toolschallenge.model.Tipo;

import java.io.IOException;

/**
 * Deserializador personalizado para o tipo {@link Tipo}.
 * <p>
 * Esta classe é responsável por converter uma representação JSON de {@link Tipo} em uma instância do tipo {@link Tipo}.
 * Ela valida o valor recebido e garante que ele seja um valor válido para o tipo {@link Tipo}.
 *
 * @author Salatiel Fiore
 */
public class TipoDeserializer extends JsonDeserializer<Tipo> {

    /**
     * Deserializa o valor JSON para uma instância do tipo {@link Tipo}.
     *
     * @param jsonParser             o parser JSON usado para ler o valor
     * @param deserializationContext o contexto de deserialização
     * @return a instância de {@link Tipo} correspondente ao valor JSON
     * @throws IOException se ocorrer um erro de I/O durante a deserialização
     */
    @Override
    public Tipo deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.getText();
        if (value.isEmpty()) {
            throw new ValidateTransactionException("O Tipo não pode está vazio.");
        }
        return Tipo.of(value).orElseThrow(() -> new ValidateTransactionException("O Tipo informado não existe."));
    }
}