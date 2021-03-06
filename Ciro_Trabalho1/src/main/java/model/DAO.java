/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpa.util.JPAEntityManager;

/**
 *
 * @author Luana
 * @param <T>
 */
public class DAO<T> {
    private final Class<T> classe;
    private EntityManager manager;
    
    public DAO(Class<T> classe){
        this.classe = classe;
    }
    
    public void adicionar (T t){
        manager = JPAEntityManager.getEntityManager();
        try{
            manager.getTransaction().begin();
            manager.persist(t);
            manager.getTransaction().commit();
        }finally{
            manager.close();
        }
    }
    
    public T consultar (Long id){
        manager = JPAEntityManager.getEntityManager();
        T instancia = manager.find(classe, id);
        manager.close();
        return instancia;
    }
    
    public void alterar (T t){
        manager = JPAEntityManager.getEntityManager();
        try{
            manager.getTransaction().begin();
            manager.merge(t);
            manager.getTransaction().commit();
        }finally{
            manager.close();
        }
    }
    
    public void excluir(Long id){
        manager = JPAEntityManager.getEntityManager();
        try{
            T t = manager.find(classe, id);
            manager.getTransaction().begin();
            manager.remove(t);
            manager.getTransaction().commit();
        }finally{
            manager.close();
        }
    }
    
    public List<T> listarGenerico (String query, Object... params){
        manager = JPAEntityManager.getEntityManager();
        Query q = manager.createNamedQuery(query);
        for(int i = 0; i < params.length; i++){
            q.setParameter(i + 1, params[i]);
        }
        List<T> lista = q.getResultList();
        manager.close();
        return lista;
    }
}
