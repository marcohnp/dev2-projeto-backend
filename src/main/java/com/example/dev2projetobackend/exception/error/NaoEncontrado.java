package com.example.dev2projetobackend.exception.error;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NaoEncontrado extends RuntimeException {
    public NaoEncontrado(String erro) {
        super(erro);
    }
}
