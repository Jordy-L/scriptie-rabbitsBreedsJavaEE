package org.libbrechtjordy.rabbitsbreedsjavaee.dao;

import java.util.List;

/**
 *
 * @author JordyL
 */
public interface GenericDao<T> {
   
    public List<T> findAll();

    public T update(T object);

    public T get(Long id);

    public void delete(T object);

    public void insert(T object);
    
    public boolean exists(Long id) ;
}
