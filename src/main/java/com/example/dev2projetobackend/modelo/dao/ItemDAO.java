package com.example.dev2projetobackend.modelo.dao;

import com.example.dev2projetobackend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ItemDAO extends JpaRepository<Item, Integer> {

    List<Item> findByNomeContainingIgnoreCase(String contem);

    List<Item> findByDataBetween(Date inicio, Date fim);
}

