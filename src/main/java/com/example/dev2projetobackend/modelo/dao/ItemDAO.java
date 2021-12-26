package com.example.dev2projetobackend.modelo.dao;

import com.example.dev2projetobackend.model.Categoria;
import com.example.dev2projetobackend.model.Item;
import com.example.dev2projetobackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ItemDAO extends JpaRepository<Item, Integer> {

    List<Item> findByNomeContainingIgnoreCase(String contem);

    Iterable<Item> findByDataInicioItemLessThan(Date menor);
    Iterable<Item> findByDataFimItemGreaterThan(Date maior);

    List <Item> findByCategoria(Categoria categoria);
    
    List <Item> findByCategoriaNomeContaining(String nome);
    
    List <Item> findByUsuario(Usuario usuario);
    
    List <Item> findByUsuarioNomeContaining(String nome);
}

