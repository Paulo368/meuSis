/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *
 * @author Paulo
 */
@Entity
public class PedidoProduto implements Serializable {
        
    @EmbeddedId
    private PedidoProdutoPK chaveComposta;
        
    private int qtde;

    public PedidoProduto() {
    }

    public PedidoProduto(Pedido pedido, Produto produto, int qtde) {
        this.qtde = qtde;
        this.chaveComposta = new PedidoProdutoPK(pedido, produto);
    }
    
    public Pedido getPedido(){
        return chaveComposta.getPedido();
    }
    
    public void setPedido(Pedido pedido) {
        chaveComposta.setPedido(pedido);
    }
    
    public Produto getProduto(){
        return chaveComposta.getProduto();
    }
    
    public void setProduto(Produto produto) {
        chaveComposta.setProduto(produto);
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
}
