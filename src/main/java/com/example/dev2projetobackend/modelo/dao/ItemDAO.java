package com.example.dev2projetobackend.modelo.dao;

import com.example.dev2projetobackend.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface ItemDAO extends CrudRepository<Item, Integer> {

    public Iterable<Item> findByNomeContaining(String contem);
    List<Item> findByDataBetween(Date inicio, Date fim);
}

