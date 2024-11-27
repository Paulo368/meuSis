/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Paulo
 */

@Entity
public class Fabricante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFabricante;

    @Column(name = "nomeFabricante", nullable = false)
    private String nome;

    @Column(nullable = true)  // Permitir nulo no telefone
    private Integer telefone;  // Alterado de int para Integer para permitir nulo

    private String email;

    @OneToMany(mappedBy = "fabricante", fetch = FetchType.LAZY)
    private List<Produto> produtos;

    public Fabricante() {
    }

    public Fabricante(int idFabricante, String nome, Integer telefone, String email) {
        this.idFabricante = idFabricante;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Fabricante(String nome, Integer telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(int idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTelefone() {  // Alterado para Integer
        return telefone;
    }

    public void setTelefone(Integer telefone) {  // Alterado para Integer
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fabricante other = (Fabricante) obj;
        return Objects.equals(this.nome, other.nome);
    }
}
