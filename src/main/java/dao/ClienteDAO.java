/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.Cliente;

/**
 *
 * @author 1547816
 */
public class ClienteDAO extends GenericDAO {

        
    private List<Cliente> pesquisar(String pesq)  {
        
        // SOMENTE PARA TESTE
        return this.listar(Cliente.class);
        
        /*
        List<Cliente> lista = new ArrayList();
      
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÃO

            sessao.getTransaction().commit();
            sessao.close();
        } catch ( HibernateException erro) {
            if ( sessao != null ) {
                sessao.getTransaction().rollback();
            }
            throw new HibernateException(erro);            
        }        
      
        
        return null; 
          */       
    }
    
    
    public List<Cliente> pesquisarPorNome(String pesq)  {
        return pesquisar(pesq);
    }
    
}
