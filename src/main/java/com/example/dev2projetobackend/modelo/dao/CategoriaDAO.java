package com.example.dev2projetobackend.modelo.dao;

import com.example.dev2projetobackend.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaDAO extends JpaRepository<Categoria, Integer> {

}
