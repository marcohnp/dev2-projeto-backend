package com.example.dev2projetobackend.controller;

import com.example.dev2projetobackend.exception.exceptions.CategoriaNotFoundException;
import com.example.dev2projetobackend.model.Usuario;
import com.example.dev2projetobackend.modelo.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<Usuario> listarUsuario() {
        return usuarioDAO.findAll();
    }


    @GetMapping(value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscarUsuario(@PathVariable Integer id) {
        return usuarioDAO.findById(id).orElseThrow(CategoriaNotFoundException::new);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity atualizarUsuario(@PathVariable("id") int id,
                                 @RequestBody Usuario usuario) {
        return usuarioDAO.findById(id)
                .map(record -> {
                    record.setNome(usuario.getNome());
                    record.setEmail(usuario.getEmail());
                    record.setTelefone(usuario.getTelefone());
                    Usuario updated = usuarioDAO.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> deleteUsuario(@PathVariable int id) {
        return usuarioDAO.findById(id)
                .map(record -> {
                    usuarioDAO.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
