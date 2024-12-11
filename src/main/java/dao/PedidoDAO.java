/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.PedidoProduto;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author 1547816
 */
public class PedidoDAO extends GenericDAO {

    public void carregarItens(Pedido ped) throws HibernateException {
        Session sessao = null;
        
        try {
                               
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Verifica se a lista JÁ FOI CARREGADA
            if ( ! Hibernate.isInitialized( ped.getListaItens() ) ) {
                
                //System.out.println("Carregar Pedido " + ped.getIdPedido() );
                
                // Carrega o PROXY para outro objeto
                Pedido pedTemp = sessao.get(Pedido.class, ped.getIdPedido()  );

                // Carrega a lista de PEDIDOS
                List<PedidoProduto> lista = pedTemp.getListaItens();
                lista.size();

                // Atualiza a lista no OBJETO principal (parâmetro)
                ped.setListaItens(lista);
            }
            
            
            sessao.getTransaction().commit();              
            sessao.close();
        } catch( HibernateException erro) {
            if ( sessao != null ){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(erro);
        }
        
    }

    
    private List<Pedido> pesquisar(int tipo, String pesq) throws HibernateException {
                
       List lista = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÃO
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta =  builder.createQuery(Pedido.class);
            Root tabela = consulta.from( Pedido.class );
            
            Predicate restricoes = null;
            
            switch (tipo) {
                case 0: //ID
                    restricoes = builder.equal( tabela.get("idPedido")  , pesq  );
                    break;
                case 1: 
                    restricoes = builder.like(tabela.get("cliente").get("nome")  , pesq + "%");
                    break;                           
            }
            
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
    
    
    public List<Pedido> pesquisarPorID(String pesq) {
         return pesquisar(0,pesq);             
    }
    
    public List<Pedido> pesquisarPorCliente(String pesq) {             
        return pesquisar(1,pesq);
    }

    

//    public List valorPorCliente() {
//        List lista = null;
//        Session sessao = null;
//        try {
//            sessao = ConexaoHibernate.getSessionFactory().openSession();
//            sessao.beginTransaction();
//
//            // OPERAÇÃO
//            CriteriaBuilder builder = sessao.getCriteriaBuilder();
//            CriteriaQuery consulta =  builder.createQuery(Object[].class);
//            Root tabela = consulta.from( Pedido.class );
//            
//            consulta.multiselect( tabela.get("cliente") ,
//                                  builder.sum( tabela.get("valorTotal") )  );
//            
//            consulta.groupBy(tabela.get("cliente")  );
//            
//            consulta.orderBy( builder.asc( tabela.get("cliente") )   );
//                        
//             // EXECUTAR
//            lista = sessao.createQuery(consulta).getResultList();
//            
//            sessao.getTransaction().commit();
//            sessao.close();
//        } catch (HibernateException ex) {
//            if (sessao != null ) {
//                sessao.getTransaction().rollback();          
//                sessao.close();
//            }
//            throw new HibernateException(ex);
//        }
//        return lista;
//        
//    }
//    
//    public List valorPorMes() {
//        List lista = null;
//        Session sessao = null;
//        try {
//            sessao = ConexaoHibernate.getSessionFactory().openSession();
//            sessao.beginTransaction();
//
//            // OPERAÇÃO
//            CriteriaBuilder builder = sessao.getCriteriaBuilder();
//            CriteriaQuery consulta =  builder.createQuery(Object[].class);
//            Root tabela = consulta.from( Pedido.class );
//            
//            Expression mes = builder.function("month", Integer.class, tabela.get("dataPedido") );
//            Expression ano = builder.function("year", Integer.class, tabela.get("dataPedido") );
//            
//            consulta.multiselect( mes, ano ,
//                                  builder.sum( tabela.get("valorTotal") )  );
//            
//            // Como EXEMPLO usandp WHERE com o ano FIXO. Deveria estar nos parâmetros
//            Predicate restricoes = null;
//            restricoes = builder.equal( ano , 2024);
//            
//            consulta.where(restricoes);
//            
//            consulta.groupBy(mes, ano  );
//            
//            consulta.orderBy( builder.asc( ano ) ,  builder.asc( mes )   );
//                        
//             // EXECUTAR
//            lista = sessao.createQuery(consulta).getResultList();
//            
//            
//            sessao.getTransaction().commit();
//            sessao.close();
//        } catch (HibernateException ex) {
//            if (sessao != null ) {
//                sessao.getTransaction().rollback();          
//                sessao.close();
//            }
//            throw new HibernateException(ex);
//        }
//        return lista;
//        
//    }    
        
}


