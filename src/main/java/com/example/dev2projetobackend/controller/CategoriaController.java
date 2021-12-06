package com.example.dev2projetobackend.controller;

import com.example.dev2projetobackend.dao.CategoriaDao;
import com.example.dev2projetobackend.exception.exceptions.CategoriaNotFoundException;
import com.example.dev2projetobackend.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaDao categoriaDao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria cadastrarCategoria(@Valid @RequestBody Categoria request) {
        return categoriaDao.save(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Categoria> listarCategorias() {
        return categoriaDao.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Categoria recuperarCategoriaPorId(@PathVariable Integer id) {
        return categoriaDao.findById(id).orElseThrow(CategoriaNotFoundException::new);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Categoria editarCategoriaPorId(@Valid @RequestBody Categoria request, @PathVariable Integer id) {
        Categoria categoria = categoriaDao.findById(id).orElseThrow(CategoriaNotFoundException::new);
        categoria.setNome(request.getNome());
        return categoriaDao.save(categoria);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCategoria(@PathVariable Integer id) {
        Categoria categoria = categoriaDao.findById(id).orElseThrow(CategoriaNotFoundException::new);
        categoriaDao.delete(categoria);
    }
}
