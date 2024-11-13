/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Paulo
 */
public class GenericDAO {
    public void inserir(Object obj) {
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            sessao.save(obj);
            
            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException erro) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
            }
            throw new HibernateException(erro);
        }
    }

    public void alterar(Object obj) {
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

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

    
    public List listar(){
        List lista = new ArrayList();

        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            Criteria consulta;
            
            

            sessao.getTransaction().commit();
            sessao.close();
        }catch(HibernateException erro){
            if(sessao != null){
                sessao.getTransaction().rollback();
            }
            throw new HibernateException(erro);
        }
        return null;
    }
}
