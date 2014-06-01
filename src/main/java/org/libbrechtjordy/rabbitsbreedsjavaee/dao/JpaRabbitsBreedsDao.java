package org.libbrechtjordy.rabbitsbreedsjavaee.dao;

import javax.ejb.Stateless;
import org.libbrechtjordy.rabbitsbreedsjavaee.entity.RabbitsBreed;

/**
 *
 * @author JordyL
 */
@Stateless 
public class JpaRabbitsBreedsDao extends GenericDaoJpa<RabbitsBreed> implements RabbitsBreedDao {

    public JpaRabbitsBreedsDao() {
        super(RabbitsBreed.class);
    }
 
}
