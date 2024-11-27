/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import control.FuncoesUteis;
import java.io.Serializable;
import java.text.ParseException;
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
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jean_
 */

@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idCliente;    
    
    @Column (name = "nomeCliente", nullable = false )
    private String nome;    

    @Column (unique = true, nullable = false, length = 14, updatable = false )
    private String cpf;    
    
    @Temporal ( value = TemporalType.DATE) 
    @Column (updatable = false)
    private Date dtNasc; 
    
    @Column ( length = 1)
    private char sexo;   
    private String telFixo;    
    
    private String celular;    
    private String email;
    
    @Lob
    private byte[] foto;
    
    
    @OneToOne (  mappedBy = "cliente", cascade = CascadeType.ALL)
    @JoinColumn ( name = "idEndereco")    
    private Endereco endereco;
    
   
    @OneToMany ( mappedBy = "cliente", fetch = FetchType.LAZY )
    private List<Pedido> pedidos;

    public Cliente() {
    }
    
    // SEM ID
    public Cliente(String nome, String cpf, Date dtNasc, char sexo, String cep, String logradouro, String bairro, int num, String complemento, String referencia, String telFixo, String celular, String email, byte[] foto) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
        this.sexo = sexo;
        this.endereco = new Endereco(cep, bairro, logradouro, num, complemento, referencia );
        this.endereco.setCliente(this);
        this.telFixo = telFixo;
        this.celular = celular;
        this.email = email;
        this.foto = foto;
    }

    // COM ID
    public Cliente(int idCliente, String nome, String cpf, Date dtNasc, char sexo, String cep, String logradouro, String bairro, int num, String complemento, String referencia, String telFixo, String celular, String email, byte[] foto) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
        this.sexo = sexo;
        this.endereco = new Endereco(idCliente, cep, bairro, logradouro, num, complemento, referencia );
        this.endereco.setCliente(this);
        this.telFixo = telFixo;
        this.celular = celular;
        this.email = email;
        this.foto = foto;
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDtNasc() {
        return dtNasc;
    }
    
    public String getDtNascFormatada() throws ParseException {
        return FuncoesUteis.dateToStr(dtNasc);
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelFixo() {
        return telFixo;
    }

    public void setTelFixo(String telFixo) {
        this.telFixo = telFixo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }


    @Override
    public String toString() {
        return nome;
    }   
    
}
