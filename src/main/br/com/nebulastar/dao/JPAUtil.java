package main.br.com.nebulastar.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Nebula Stardust
 */
public class JPAUtil {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("meuPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}

