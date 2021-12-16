package com.example.dev2projetobackend.controller;

import com.example.dev2projetobackend.exception.exceptions.UsuarioNotFoundException;
import com.example.dev2projetobackend.model.Usuario;
import com.example.dev2projetobackend.modelo.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/usuarios")
public class Usuarios {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario adicionarUsuario (@RequestBody Usuario usuario){
        return usuarioDAO.save(usuario);
    }

    @GetMapping(value = "/usuario")
    public List<Usuario> listarUsuario() {
        return usuarioDAO.findAll();
    }

    @GetMapping(value="/usuario/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscaUsuarioUnico(@PathVariable Integer id) {
        return usuarioDAO.findById(id).orElseThrow(UsuarioNotFoundException::new);
    }

    @PutMapping(value = "/usuario")
    public Usuario atualizaUsuario(@RequestBody @Valid Usuario usuario) {
        return usuarioDAO.save(usuario);
    }

    @DeleteMapping("/usuario")
    public void deletaUsuario(@RequestBody @Valid Usuario usuario) {
        usuarioDAO.delete(usuario);
    }

}