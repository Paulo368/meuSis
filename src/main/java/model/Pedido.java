/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Paulo
 */

@Entity
public class Pedido implements Serializable {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idPedido;
    
    @Temporal ( value = TemporalType.DATE) 
    @Column (updatable = false)
    private Date dtPedido; 
    private double preco;
    private int codigo;
    private int Qtde;
    
    @ManyToOne ( fetch = FetchType.EAGER )
    @JoinColumn ( name = "idCliente")
    private Cliente cliente;
    
    
    @OneToMany ( mappedBy = "chaveComposta.pedido", cascade = CascadeType.ALL )
    private List<PedidoProduto> listaItens;

    public Pedido() {
    }

    public Pedido(int idPedido, Date dtPedido, double preco, int codigo, int Qtde, Cliente cliente, List<PedidoProduto> listaItens) {
        this.idPedido = idPedido;
        this.dtPedido = dtPedido;
        this.preco = preco;
        this.codigo = codigo;
        this.Qtde = Qtde;
        this.cliente = cliente;
        this.listaItens = listaItens;
    }

    public Pedido(Date dtPedido, double preco, int codigo, int Qtde, Cliente cliente, List<PedidoProduto> listaItens) {
        this.dtPedido = dtPedido;
        this.preco = preco;
        this.codigo = codigo;
        this.Qtde = Qtde;
        this.cliente = cliente;
        this.listaItens = listaItens;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQtde() {
        return Qtde;
    }

    public void setQtde(int Qtde) {
        this.Qtde = Qtde;
    }

    public List<PedidoProduto> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<PedidoProduto> listaItens) {
        this.listaItens = listaItens;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getDtPedido() {
        return dtPedido;
    }

    public void setDtPedido(Date dtPedido) {
        this.dtPedido = dtPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public String toString() {
        return String.valueOf(idPedido);
    }
    
}
