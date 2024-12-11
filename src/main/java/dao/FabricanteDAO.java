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
import model.Fabricante;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Paulo
 */
public class FabricanteDAO extends GenericDAO{
    private List<Fabricante> pesquisar(String pesq)  {
        
        List lista = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÃO
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta =  builder.createQuery(Fabricante.class);
            Root tabela = consulta.from( Fabricante.class );
            
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
    
    
    public List<Fabricante> pesquisarPorNome(String pesq)  {
        return pesquisar(pesq);
    }
}
