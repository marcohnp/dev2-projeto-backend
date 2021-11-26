package com.example.dev2projetobackend.modelo.dao;

import com.example.dev2projetobackend.modelo.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaDao extends JpaRepository<Categoria, Integer> {
}
