/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.ClienteDAO;
import dao.ConexaoHibernate;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.Icon;
import model.Cliente;
import org.hibernate.HibernateException;

/**
 *
 * @author 1547816
 */
public class GerenciadorDominio {

    private ClienteDAO cliDAO;
//    private PedidoDAO pedDAO;
    
    
    
    public GerenciadorDominio() throws ExceptionInInitializerError, HibernateException {
    
        // CONEXAO com o BD
        ConexaoHibernate.getSessionFactory().openSession();
        
        cliDAO = new ClienteDAO();
//        pedDAO = new PedidoDAO();
        
    }
    
    
    
    public List<Cliente> listarCliente() throws ClassNotFoundException, SQLException {
        return cliDAO.listar();
    }
    
    public int inserirCliente(String nome, String cpf, Date dtNasc, char sexo,
            String cep, String ender, int num, String complemento, String bairro,
            String referencia, String telFixo, String celular, String email, Icon foto) throws ClassNotFoundException, SQLException  {

        Cliente cli = new Cliente(nome, cpf, dtNasc, sexo, cep, ender, bairro,
                num, complemento,referencia, telFixo, celular, email, 
            FuncoesUteis.IconToBytes(foto));
                
        cliDAO.inserir(cli);
        
        return cli.getIdCliente();
        
    }
    
    public void alterarCliente(int idCliente, String nome, String cpf, Date dtNasc, char sexo,
            String cep, String ender, int num, String complemento, String bairro,
            String referencia, String telFixo, String celular, String email, Icon foto) throws ClassNotFoundException, SQLException  {

        Cliente cli = new Cliente(idCliente, nome, cpf, dtNasc, sexo, cep, ender, bairro,
                num, complemento,referencia, telFixo, celular, email, 
            FuncoesUteis.IconToBytes(foto));
        
        cliDAO.alterar(cli);            
        
    }
    
    public void excluirCliente (Cliente cli) throws ClassNotFoundException, SQLException {
        cliDAO.excluir(cli);            
    }
    
    
    public List<Cliente> pesquisarCliente(String pesq, int tipo) throws ClassNotFoundException, SQLException {
        
        switch (tipo) {
            case 0: return cliDAO.pesquisarPorNome(pesq);
            case 1: return cliDAO.pesquisarPorBairro(pesq);
            case 2: return cliDAO.pesquisarPorMes(pesq);
            default: return null;
        }
        
    }
    
    
}
