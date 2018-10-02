/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Luana
 */
public class JPAEntityManager {
    private static final String PU_NAME = "TrabalhoPU";
    private static EntityManagerFactory emf = null;
    
    public static EntityManager getEntityManager() {
        if (emf == null){
            emf = Persistence.createEntityManagerFactory(PU_NAME);
        }
        return emf.createEntityManager();
    }
}
