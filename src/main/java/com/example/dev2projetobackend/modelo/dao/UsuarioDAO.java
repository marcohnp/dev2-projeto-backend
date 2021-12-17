package com.example.dev2projetobackend.modelo.dao;

import com.example.dev2projetobackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {
}
