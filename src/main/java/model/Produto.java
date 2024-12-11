/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Paulo
 */
@Entity
public class Produto implements Serializable{
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idProduto;  
    private String nome;
    private double preco;
    private int codigo;
    
    @ManyToOne ( fetch = FetchType.EAGER )
    @JoinColumn ( name = "idCliente")
    private Fabricante fabricante;

    public Produto() {
    }

    public Produto(int idProduto, String nome, double preco, int codigo) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
        this.codigo = codigo;
    }

    public Produto(String nome, double preco, int codigo) {
        this.nome = nome;
        this.preco = preco;
        this.codigo = codigo;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return nome;
    }   
    
}
