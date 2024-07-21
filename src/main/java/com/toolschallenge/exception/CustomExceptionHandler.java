package com.toolschallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseMessageError> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return popularResponseMessageError(message, HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @ExceptionHandler(ValidateTransactionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseMessageError> handleValidateException(ValidateTransactionException ex) {
        String message = ex.getMessage();
        return popularResponseMessageError(message, HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @ExceptionHandler(NotFoundTransactionException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseMessageError> handleNotFoundException(NotFoundTransactionException ex) {
        String message = ex.getMessage();
        return popularResponseMessageError(message, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
    }

    /**
     * Método para popular o response para cada exceção.
     *
     * @param message A exceção.
     * @param status  O código de status HTTP.
     * @param error   A mensagem de erro.
     * @return ResponseEntity<ResponseMessageError>
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
