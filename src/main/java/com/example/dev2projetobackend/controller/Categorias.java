package com.example.dev2projetobackend.controller;


import com.example.dev2projetobackend.exception.exceptions.CategoriaNotFoundException;
import com.example.dev2projetobackend.modelo.dao.CategoriaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class Categorias {

    @Autowired
    private CategoriaDAO categoriaDao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public com.example.dev2projetobackend.model.Categoria cadastrarCategoria(@Valid @RequestBody com.example.dev2projetobackend.model.Categoria request) {
        return categoriaDao.save(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<com.example.dev2projetobackend.model.Categoria> listarCategorias() {
        return categoriaDao.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public com.example.dev2projetobackend.model.Categoria recuperarCategoriaPorId(@PathVariable Integer id) {
        return categoriaDao.findById(id).orElseThrow(CategoriaNotFoundException::new);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public com.example.dev2projetobackend.model.Categoria editarCategoriaPorId(@Valid @RequestBody com.example.dev2projetobackend.model.Categoria request, @PathVariable Integer id) {
        com.example.dev2projetobackend.model.Categoria categoria = categoriaDao.findById(id).orElseThrow(CategoriaNotFoundException::new);
        categoria.setNome(request.getNome());
        return categoriaDao.save(categoria);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCategoria(@PathVariable Integer id) {
        com.example.dev2projetobackend.model.Categoria categoria = categoriaDao.findById(id).orElseThrow(CategoriaNotFoundException::new);
        categoriaDao.delete(categoria);
    }
}
