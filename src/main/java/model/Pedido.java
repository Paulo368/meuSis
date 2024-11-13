/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private double valorTotal;
    
    @ManyToOne ( fetch = FetchType.EAGER )
    @JoinColumn ( name = "idCliente")
    private Cliente cliente;

    public Pedido() {
    }
    
    public Pedido(int idPedido, Date dtPedido, double valorTotal, Cliente cliente) {
        this.idPedido = idPedido;
        this.dtPedido = dtPedido;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
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

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public String toString() {
        return String.valueOf(idPedido);
    }
    
}
