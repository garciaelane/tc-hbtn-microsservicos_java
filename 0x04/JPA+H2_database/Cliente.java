package com.example.jpah2demo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome, email;
    private Integer idade;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_telefone", referencedColumnName = "id")
    private List<Telefone> telefones;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_endereco", referencedColumnName = "id")
    private List<Endereco> enderecos;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String email, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id) && nome.equals(cliente.nome) && email.equals(cliente.email) && idade.equals(cliente.idade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, idade);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                '}';
    }
}
