package main.br.com.nebulastar.dao;
import javax.persistence.EntityManager;
import java.util.List;
/**
 * Created by Nebula Stardust
 */
public class GenericDAO<T> {

    private Class<T> classe;

    public GenericDAO(Class<T> classe) {
        this.classe = classe;
    }

    public void salvar(T entidade) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        em.persist(entidade);

        em.getTransaction().commit();
        em.close();
    }

    public T buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();

        T obj = em.find(classe, id);

        em.close();
        return obj;
    }

    public List<T> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();

        List<T> lista = em
                .createQuery("FROM " + classe.getSimpleName(), classe)
                .getResultList();

        em.close();
        return lista;
    }

    public void remover(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        T obj = em.find(classe, id);
        if (obj != null) {
            em.remove(obj);
        }

        em.getTransaction().commit();
        em.close();
    }
}
