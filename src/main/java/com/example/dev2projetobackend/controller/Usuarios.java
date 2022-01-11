package com.example.dev2projetobackend.controller;

import com.example.dev2projetobackend.exception.exceptions.UsuarioNotFoundException;
import com.example.dev2projetobackend.model.Usuario;
import com.example.dev2projetobackend.modelo.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class Usuarios {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario adicionarUsuario(@RequestBody Usuario usuario) {
        return usuarioDAO.save(usuario);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> listarUsuario() {
        return usuarioDAO.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscaUsuarioUnico(@PathVariable Integer id) {
        return usuarioDAO.findById(id).orElseThrow(UsuarioNotFoundException::new);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Usuario atualizarUsuario(@Valid @RequestBody Usuario usuarioBanco, @PathVariable Integer id) {
        Usuario usuario = usuarioDAO.findById(id).orElseThrow(UsuarioNotFoundException::new);
        usuario.setUsuario(usuarioBanco.getUsuario());
        usuario.setNome(usuarioBanco.getNome());
        usuario.setCpf(usuarioBanco.getCpf());
        usuario.setEmail(usuarioBanco.getEmail());
        usuario.setTelefone(usuarioBanco.getTelefone());
        return usuarioDAO.save(usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUsuario(@PathVariable Integer id) {
        Usuario usuario = usuarioDAO.findById(id).orElseThrow(UsuarioNotFoundException::new);
        usuarioDAO.delete(usuario);
    }

}