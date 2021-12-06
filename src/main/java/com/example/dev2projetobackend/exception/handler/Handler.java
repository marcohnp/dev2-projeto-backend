package com.example.dev2projetobackend.exception.handler;

import com.example.dev2projetobackend.exception.error.StandardError;
import com.example.dev2projetobackend.exception.exceptions.CategoriaNotFoundException;
import com.example.dev2projetobackend.exception.exceptions.RequestInvalidaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class Handler {

    @ExceptionHandler(CategoriaNotFoundException.class)
    public ResponseEntity<StandardError> pagamentoNotFound(CategoriaNotFoundException e, HttpServletRequest request) {
        return new ResponseEntity<>(new StandardError(Instant.now(), HttpStatus.NOT_FOUND.value(),
                "Request não completada.", e.getMessage(), request.getRequestURI()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RequestInvalidaException.class)
    public ResponseEntity<StandardError> requestInvalida(RequestInvalidaException e, HttpServletRequest request) {
        return new ResponseEntity<>(new StandardError(Instant.now(), HttpStatus.BAD_REQUEST.value(),
                "Request não completada.", e.getMessage(), request.getRequestURI()), HttpStatus.BAD_REQUEST);
    }
}
