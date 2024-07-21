package com.toolschallenge.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.toolschallenge.exception.ValidateTransactionException;
import com.toolschallenge.model.Tipo;

import java.io.IOException;

public class TipoDeserializer extends JsonDeserializer<Tipo> {
    @Override
    public Tipo deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.getText();
        if (value.isEmpty()) {
            throw new ValidateTransactionException("O Tipo não pode está vazio.");
        }
        return Tipo.of(value).orElseThrow(() -> new ValidateTransactionException("O Tipo informado não existe."));
    }
}