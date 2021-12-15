/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dev2projetobackend.exception.exceptions;

/**
 *
 * @author Suporte
 */
public class UsuarioNotFoundException extends RuntimeException{
    
    public UsuarioNotFoundException() {
        super("Usuario não encontrado");
    }
}
