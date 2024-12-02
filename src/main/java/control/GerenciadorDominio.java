/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.ClienteDAO;
import dao.ConexaoHibernate;
import dao.GenericDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.Icon;
import model.Cidade;
import model.Cliente;
import model.Fabricante;
import model.ItemPedido;
import model.Pedido;
import model.PedidoProduto;
import model.Produto;
import org.hibernate.HibernateException;

/**
 *
 * @author 1547816
 */
public class GerenciadorDominio {

    private ClienteDAO cliDAO;
    private GenericDAO generic;

    public GerenciadorDominio() throws ExceptionInInitializerError, HibernateException {

        // CONEXAO com o BD
        ConexaoHibernate.getSessionFactory().openSession();

        cliDAO = new ClienteDAO();
        generic = new GenericDAO();

    }

    // ######################    
    //  Métodos GENÉRICOS
    // ######################
    public List listar(Class classe) throws HibernateException {
        return cliDAO.listar(classe);
    }

    public void excluir(Object obj) throws HibernateException {
        cliDAO.excluir(obj);
    }

    // ###############################
    public int inserirCliente(String nome, String cpf, Date dtNasc, char sexo,
            String cep, String ender, int num, String complemento, String bairro,
            String referencia, String telFixo, String celular, String email, Icon foto) throws HibernateException {

        Cliente cli = new Cliente(nome, cpf, dtNasc, sexo, cep, ender, bairro,
                num, complemento, referencia, telFixo, celular, email,
                FuncoesUteis.IconToBytes(foto));

        cliDAO.inserir(cli);

        return cli.getIdCliente();

    }

    public void alterarCliente(int idCliente, String nome, String cpf, Date dtNasc, char sexo,
            String cep, String ender, int num, String complemento, String bairro,
            String referencia, String telFixo, String celular, String email, Icon foto) throws HibernateException {

        Cliente cli = new Cliente(idCliente, nome, cpf, dtNasc, sexo, cep, ender, bairro,
                num, complemento, referencia, telFixo, celular, email,
                FuncoesUteis.IconToBytes(foto));

        cliDAO.alterar(cli);

    }

    public int inserirFabricante(String nome, int telefone, String email) throws HibernateException {
        Fabricante fab = new Fabricante(nome, telefone, email);
        generic.inserir(fab);

        return fab.getIdFabricante();
    }

    public void alterarFabricante(int idFabricante, String nome, int telefone, String email) throws HibernateException {
        Fabricante fab = new Fabricante(idFabricante, nome, telefone, email);
        generic.alterar(fab);
    }

    public int inserirPedido(String nome, int telefone, String email) throws HibernateException {
        Fabricante fab = new Fabricante(nome, telefone, email);
        generic.inserir(fab);

        return fab.getIdFabricante();
    }

    public int inserirProduto(String nome, double preco, Fabricante fabricante) throws HibernateException {
        Produto produto = new Produto(nome, preco);
        produto.setFabricante(fabricante);
        generic.inserir(produto);

        return produto.getIdProduto();
    }

    public List<Cliente> pesquisarCliente(String pesq) throws HibernateException {
        return cliDAO.pesquisarPorNome(pesq);
    }

    public void inserirPedido(Date dataPedido, double preco, int codigo, int quantidade, Cliente cliente, List<PedidoProduto> listaItens) {
        Pedido ped = new Pedido(dataPedido, preco, codigo, quantidade, cliente, listaItens);
        cliDAO.inserir(ped);
    }

}
