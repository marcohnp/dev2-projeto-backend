package com.example.dev2projetobackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nome;
    @NotNull
    private String usuario;
    @NotNull
    private String senha;
    @NotNull
    private String cpf;
    @NotNull
    private String email;
    @NotNull
    private String telefone;

    public Usuario() {
    }

    public Usuario(int id, String nome, String usuario, String senha, String cpf, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

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
        Usuario usuario1 = (Usuario) o;
        return id == usuario1.id && Objects.equals(nome, usuario1.nome) && Objects.equals(usuario, usuario1.usuario) && Objects.equals(senha, usuario1.senha) && Objects.equals(cpf, usuario1.cpf) && Objects.equals(email, usuario1.email) && Objects.equals(telefone, usuario1.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, usuario, senha, cpf, email, telefone);
    }
}
