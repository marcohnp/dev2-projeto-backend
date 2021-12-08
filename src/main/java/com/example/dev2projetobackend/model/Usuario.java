/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dev2projetobackend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nome;
    // private String usuario; -> comentário: precisamos mesmo desse atributo?
    private String senha;
    private String cpf;
    private String email;
    private String telefone;

    public Usuario() {
    }

    public Usuario(int id, String nome, String senha, String cpf, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //public String getUsuario() { return usuario; }

    //public void setUsuario(String usuario) {this.usuario = usuario;}

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
