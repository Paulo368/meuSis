/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;
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
public class Fabricante implements Serializable{
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idFabricante;
    
    @Column (name = "nomeCliente", nullable = false )
    private String nome;
    @Column ( insertable = false )
    private String telefone; 
    private String email;
    
    
    
    @OneToMany ( mappedBy = "fabricante", fetch = FetchType.LAZY )
    private List<Produto> produtos;
    
    

    public Fabricante() {
    }

    public Fabricante(int idFabricante, String nome, String telefone, String email) {
        this.idFabricante = idFabricante;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
