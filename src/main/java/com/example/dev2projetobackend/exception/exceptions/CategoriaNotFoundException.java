package com.example.dev2projetobackend.exception.exceptions;

public class CategoriaNotFoundException extends RuntimeException {

    public CategoriaNotFoundException() {
        super("Categoria não encontrada");
    }
}
