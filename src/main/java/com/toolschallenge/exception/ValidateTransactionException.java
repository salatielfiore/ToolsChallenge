package com.toolschallenge.exception;

/**
 * Exceção lançada quando há uma falha na validação de uma transação.
 * <p>
 * Esta classe é uma subclasse de {@link RuntimeException} e é usada para indicar
 * que ocorreu um erro durante a validação de uma transação, por exemplo, quando um
 * tipo de transação inválido é fornecido ou algum outro erro de validação ocorre.
 *
 * @author Salatiel Fiore
 */
public class ValidateTransactionException extends RuntimeException {

    public ValidateTransactionException(String message) {
        super(message);
    }
}
