package com.example.dev2projetobackend.modelo.dao;

import com.example.dev2projetobackend.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemDAO extends CrudRepository<Item, Integer> {
}
