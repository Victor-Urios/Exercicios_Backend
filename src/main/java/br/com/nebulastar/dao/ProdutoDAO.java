package main.java.br.com.nebulastar.dao;

import main.java.br.com.nebulastar.domain.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Nebula Stardust
 */
public class ProdutoDAO implements IProdutoDAO {


    @Override
    public Produto cadastrar(Produto prod) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(prod);
        em.getTransaction().commit();

        em.close();
        emf.close();

        return prod;
    }
    }
