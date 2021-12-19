package com.example.dev2projetobackend.exception.exceptions;

public class UsuarioNotFoundException extends RuntimeException{

    public UsuarioNotFoundException() {

        super("Usuario não encontrado");
    }
}
