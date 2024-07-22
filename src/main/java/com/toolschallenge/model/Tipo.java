package com.toolschallenge.model;

import java.util.Optional;

/**
 * Enumeração que representa os diferentes tipos de pagamento.
 * <p>
 * Esta enumeração define três tipos de pagamento possíveis:
 * <ul>
 *     <li><strong>AVISTA</strong> - Pagamento à vista.</li>
 *     <li><strong>PARCELADO_LOJA</strong> - Pagamento parcelado na loja.</li>
 *     <li><strong>PARCELADO_EMISSOR</strong> - Pagamento parcelado pelo emissor.</li>
 * </ul>
 * <p>
 * A enumeração oferece métodos para comparar e buscar tipos de pagamento com base em suas representações em string.
 *
 * @author Salatiel Fiore
 */
public enum Tipo {

    AVISTA("AVISTA"),
    PARCELADO_LOJA("PARCELADO LOJA"),
    PARCELADO_EMISSOR("PARCELADO EMISSOR");

    final String value;

    Tipo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    /**
     * Compara o valor do tipo de pagamento com o valor fornecido.
     *
     * @param value O valor a ser comparado.
     * @return True se os valores forem iguais, ignorando maiúsculas e minúsculas.
     */
    public boolean sameOf(String value) {
        return this.value.equalsIgnoreCase(value);
    }

    /**
     * Obtém o tipo de pagamento correspondente ao valor fornecido.
     *
     * @param mimeType O valor em string do tipo de pagamento.
     * @return Um {@link Optional} contendo o tipo de pagamento correspondente, se encontrado; caso contrário, um {@link Optional} vazio.
     */
    public static Optional<Tipo> of(String mimeType) {
        for (Tipo tipo : values()) {
            if (tipo.sameOf(mimeType)) {
                return Optional.of(tipo);
            }
        }
        return Optional.empty();
    }
}
