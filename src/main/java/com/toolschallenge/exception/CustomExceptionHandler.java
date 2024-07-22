package com.toolschallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Classe de tratamento global de exceções para a aplicação.
 * <p>
 * Esta classe captura e processa exceções lançadas durante a execução dos controladores,
 * retornando respostas adequadas para erros de validação e exceções específicas.
 *
 * @author Salatiel Fiore
 */
@ControllerAdvice
public class CustomExceptionHandler {

    /**
     * Manipula exceções de validação de argumentos de método.
     *
     * @param ex a exceção {@link MethodArgumentNotValidException} lançada quando a validação dos argumentos falha
     * @return uma resposta com a mensagem de erro e o status HTTP 400 (Bad Request)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseMessageError> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return popularResponseMessageError(message, HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    /**
     * Manipula exceções de validação de transação.
     *
     * @param ex a exceção {@link ValidateTransactionException} lançada para erros de validação de transação
     * @return uma resposta com a mensagem de erro e o status HTTP 400 (Bad Request)
     */
    @ExceptionHandler(ValidateTransactionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseMessageError> handleValidateException(ValidateTransactionException ex) {
        String message = ex.getMessage();
        return popularResponseMessageError(message, HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    /**
     * Manipula exceções de transações não encontradas.
     *
     * @param ex a exceção {@link NotFoundTransactionException} lançada quando uma transação não é encontrada
     * @return uma resposta com a mensagem de erro e o status HTTP 404 (Not Found)
     */
    @ExceptionHandler(NotFoundTransactionException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseMessageError> handleNotFoundException(NotFoundTransactionException ex) {
        String message = ex.getMessage();
        return popularResponseMessageError(message, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
    }

    /**
     * Método auxiliar para popular a resposta de erro com base na exceção.
     *
     * @param message A mensagem de erro a ser retornada
     * @param status  O código de status HTTP da resposta
     * @param error   A descrição do erro
     * @return um {@link ResponseEntity} contendo o {@link ResponseMessageError} com a mensagem de erro e o status
     */
    private static ResponseEntity<ResponseMessageError> popularResponseMessageError(
            String message, Integer status, String error) {
        ResponseMessageError err = new ResponseMessageError();
        err.setStatus(status);
        err.setError(error);
        err.setMessage(message);
        return ResponseEntity.status(status).body(err);
    }
}
