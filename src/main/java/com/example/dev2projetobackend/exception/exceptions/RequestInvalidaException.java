package com.example.dev2projetobackend.exception.exceptions;

public class RequestInvalidaException extends RuntimeException {

    public RequestInvalidaException() {
        super("Request inválida. Verifique os campos obrigatórios");
    }
}
