package com.toolschallenge.dto.response;

/**
 * DTO (Data Transfer Object) para a forma de pagamento.
 * <p>
 * Esta classe é utilizada para transferir dados de resposta relacionados à forma de pagamento de uma transação.
 * Contém informações sobre o tipo de pagamento e o número de parcelas.
 *
 * @author Salatiel Fiore
 */
public class FormaPagamentoResponseDTO {

    private String tipo;
    private String parcelas;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

}
