package com.toolschallenge.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.toolschallenge.model.Tipo;

import java.io.IOException;

public class TipoDeserializer extends JsonDeserializer<Tipo> {
    @Override
    public Tipo deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.getText();
        return Tipo.of(value).orElseThrow(() -> new IOException("Tipo inválido: " + value));
    }
}