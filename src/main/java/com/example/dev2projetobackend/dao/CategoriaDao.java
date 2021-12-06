package com.example.dev2projetobackend.dao;

import com.example.dev2projetobackend.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaDao extends JpaRepository<Categoria, Integer> {
}
