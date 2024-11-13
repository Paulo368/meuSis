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
    
    private double preco;
    private int estoque;
    
    @ManyToOne ( fetch = FetchType.EAGER )
    @JoinColumn ( name = "idCliente")
    private Fabricante fabricante;

    public Produto() {
    }

    public Produto(int idProduto, double preco, int estoque, Fabricante fabricante) {
        this.idProduto = idProduto;
        this.preco = preco;
        this.estoque = estoque;
        this.fabricante = fabricante;
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

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
    
    @Override
    public String toString() {
        return String.valueOf(idProduto);
    }
    
    
}
