/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author 1547816
 */
public class GenericDAO {

    public void inserir(Object obj) throws HibernateException {
        Session sessao = null;
        try {
            // Abrir a sessão
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Realizar a operação de inserção
            sessao.save(obj);

            // Commit da transação
            sessao.getTransaction().commit();
        } catch (HibernateException erro) {
            // Caso ocorra erro, realizar rollback
            if (sessao != null && sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }
            throw new HibernateException("Erro ao salvar o objeto", erro);
        } finally {
            // Fechar a sessão depois da transação ser concluída ou em caso de erro
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    public void alterar(Object obj) {
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÃO
            sessao.update(obj);

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException erro) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
            }
            throw new HibernateException(erro);
        }

    }

    public void excluir(Object obj) {
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÃO
            sessao.delete(obj);

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException erro) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
            }
            throw new HibernateException(erro);
        }
    }

    public List listar(Class classe) {
        List lista = new ArrayList();
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÃO
            CriteriaQuery consulta = sessao.getCriteriaBuilder().createQuery(classe);
            consulta.from(classe);
            lista = sessao.createQuery(consulta).getResultList();

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException erro) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
            }
            throw new HibernateException(erro);
        }

        return lista;
    }

}
