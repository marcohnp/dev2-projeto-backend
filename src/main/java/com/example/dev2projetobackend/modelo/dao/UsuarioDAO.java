/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dev2projetobackend.modelo.dao;

import com.example.dev2projetobackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Suporte
 */
@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

}
