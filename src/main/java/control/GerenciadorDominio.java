/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.ClienteDAO;
import dao.ConexaoHibernate;
import dao.FabricanteDAO;
import dao.GenericDAO;
import dao.PedidoDAO;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Fabricante;
import model.Pedido;
import model.PedidoProduto;
import model.Produto;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author 1547816
 */
public class GerenciadorDominio {

    private ClienteDAO cliDAO;
    private GenericDAO generic;
    private FabricanteDAO fabDAO;
    private PedidoDAO pedDAO;

    public GerenciadorDominio() throws ExceptionInInitializerError, HibernateException {

        // CONEXAO com o BD
        ConexaoHibernate.getSessionFactory().openSession();

        cliDAO = new ClienteDAO();
        generic = new GenericDAO();
        fabDAO = new FabricanteDAO();
        pedDAO = new PedidoDAO();

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

    public int inserirPedido(Date dtPedido, int qtde, double valorTotal, Cliente cliente) throws HibernateException {
        Pedido ped = new Pedido(dtPedido, qtde, valorTotal, cliente);

        // Abrir sessão e iniciar transação
        Session sessao = ConexaoHibernate.getSessionFactory().openSession();
        try {
            sessao.beginTransaction();

            // Salvar o pedido (com os itens devido ao CascadeType.ALL)
            sessao.save(ped);

            // Commit da transação
            sessao.getTransaction().commit();
        } catch (HibernateException erro) {
            // Caso ocorra erro, realizar rollback
            if (sessao != null && sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }
            throw new HibernateException("Erro ao salvar o pedido e seus itens", erro);
        } finally {
            // Fechar a sessão
            if (sessao != null) {
                sessao.close();
            }
        }
        return ped.getIdPedido();
    }

    public int inserirProduto(String nome, double preco, int codigo, Fabricante fabricante) throws HibernateException {
        Produto produto = new Produto(nome, preco, codigo);
        produto.setFabricante(fabricante);
        generic.inserir(produto);

        return produto.getIdProduto();
    }

    public List<Cliente> pesquisarCliente(String pesq) throws HibernateException {
        return cliDAO.pesquisarPorNome(pesq);
    }

    public List<Fabricante> pesquisarFabricante(String pesq) throws HibernateException {
        return fabDAO.pesquisarPorNome(pesq);
    }

    public List<Pedido> pesquisarPedido(int tipo, String pesq) throws HibernateException {
        switch (tipo) {
            case 0:
                return pedDAO.pesquisarPorID(pesq);
            case 1:
                return pedDAO.pesquisarPorCliente(pesq);
            default:
                return null;
        }

    }

    public void getItensPedido(Pedido pedido) throws HibernateException {
        pedDAO.carregarItens(pedido);
    }

    public void relGroupBy(JTable tabela, int tipo) throws Exception {
        List<Object[]> lista = null;

        // Limpa a tabela
        ((DefaultTableModel) tabela.getModel()).setRowCount(0);

        switch (tipo) {
            case 'C':
                lista = pedDAO.valorPorCliente();
                break;
        }

        NumberFormat formato = NumberFormat.getCurrencyInstance();

        // Percorrer a LISTA
        if (lista != null) {

            for (Object[] obj : lista) {
                switch (tipo) {
                    case 'C':
                        obj[1] = formato.format(Double.parseDouble(obj[1].toString()));
                        break;

                }

                ((DefaultTableModel) tabela.getModel()).addRow(obj);
            }

        }
    }

    public Pedido carregarPedido(int idPedido) throws HibernateException {
        Session sessao = null;
        Pedido pedido = null;

        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            pedido = sessao.get(Pedido.class, idPedido); // Carrega o pedido pelo ID
        } catch (HibernateException erro) {
            throw new HibernateException("Erro ao carregar o pedido", erro);
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        return pedido;
    }

}
