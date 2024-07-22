package com.toolschallenge.exception;

/**
 * Exceção lançada quando uma transação não é encontrada.
 * <p>
 * Esta classe estende {@link RuntimeException} e é usada para indicar que uma transação
 * solicitada não pôde ser localizada na base de dados ou repositório.
 *
 * @author Salatiel Fiore
 */
public class NotFoundTransactionException extends RuntimeException {

    public NotFoundTransactionException(String message) {
        super(message);
    }
}
