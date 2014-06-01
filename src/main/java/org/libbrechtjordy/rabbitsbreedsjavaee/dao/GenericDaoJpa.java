package org.libbrechtjordy.rabbitsbreedsjavaee.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JordyL
 */
public class GenericDaoJpa<T> implements GenericDao<T> {

    private Class<T> type;
    
    @PersistenceContext(unitName = "rabbitsBreedsJTA")
    private EntityManager em;

    public GenericDaoJpa(Class<T> type) {
        super(); 
        this.type = type;
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("rabbitsBreedsLocal");
        //em = emf.createEntityManager();
    }

    @Override
    public T get(Long id) {
        T entity = this.em.find(this.type, id);
        return entity;
    }

    @Override
    public List<T> findAll() {
        return this.em.createQuery("select entity from " + this.type.getName() + " entity").getResultList();
    }

    @Override
    public void insert(T object) {
        em.persist(object);
    }

    @Override
    public void delete(T object) {
        em.remove(em.merge(object));
    }

    @Override
    public boolean exists(Long id) {
        T entity = this.em.find(this.type, id);
        return entity != null;
    }

    @Override
    public T update(T object) {
        return em.merge(object);
    }
}
