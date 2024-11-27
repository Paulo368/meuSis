package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;



/**
 *
 * @author 1547816
 */
@Entity
public class Endereco implements Serializable {    

    @Id  
    
    private int idEndereco;
    
    @Column ( length = 9)
    private String cep; 
    
    private String bairro;
    private String logradouro;
    private int numero;
    private String complemento;
    private String referencia;  
    private String cidade;
    
    @Column ( length = 2)
    private String uf;   
    
    

    @OneToOne
    @MapsId
    @JoinColumn ( name = "idEndereco")
    private Cliente cliente;
    
    public Endereco() {
    }

    
    public Endereco(String cep, String uf, String bairro, String cidade, String logradouro, String complemento) {
        this.cep = cep;
        this.uf = uf;
        this.bairro = bairro;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.complemento = complemento;
    }

    // Para ser UTILIZADO pela classe CLIENTE
    // Sem ID
    public Endereco(String cep, String bairro, String logradouro, int num, String complemento, String ref) {
        this.cep = cep;
        this.uf = "";
        this.bairro = bairro;
        this.cidade = "";
        this.logradouro = logradouro;
        this.numero = num;
        this.complemento = complemento;
        this.referencia = ref;
    }

    // Para ser UTILIZADO pela classe CLIENTE
    // Com ID
    public Endereco(int idEnder, String cep, String bairro, String logradouro, int num, String complemento, String ref) {
        this.idEndereco = idEnder;
        this.cep = cep;
        this.uf = "";
        this.bairro = bairro;
        this.cidade = "";
        this.logradouro = logradouro;
        this.numero = num;
        this.complemento = complemento;
        this.referencia = ref;
    }
    
    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
