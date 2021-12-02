/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dev2projetobackend.modelo.dao;

import com.example.dev2projetobackend.modelo.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Suporte
 */
public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
    
}
