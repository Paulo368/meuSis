/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import model.Cliente;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author 1547816
 */
public class ClienteDAO extends GenericDAO {

        
    private List<Cliente> pesquisar(String pesq)  {
        
        List lista = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÃO
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta =  builder.createQuery(Cliente.class);
            Root tabela = consulta.from( Cliente.class );
            
            Predicate restricoes = builder.like(tabela.get("nome"), pesq + "%");
            
            consulta.where(restricoes);
            
            // EXECUTAR
            lista = sessao.createQuery(consulta).getResultList();
            

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null ) {
                sessao.getTransaction().rollback();          
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return lista;   
    }
    
    
    public List<Cliente> pesquisarPorNome(String pesq)  {
        return pesquisar(pesq);
    }
    
}
