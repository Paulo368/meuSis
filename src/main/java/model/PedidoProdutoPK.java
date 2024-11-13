/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Paulo
 */
@Embeddable
public class PedidoProdutoPK implements Serializable{
    @ManyToOne
    @JoinColumn (name = "idPedido")
    private Pedido pedido;
    
    @ManyToOne
    @JoinColumn (name = "idProduto")
    private Produto produto;

    public PedidoProdutoPK() {
    }

    public PedidoProdutoPK(Pedido pedido, Produto produto) {
        this.pedido = pedido;
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
}
