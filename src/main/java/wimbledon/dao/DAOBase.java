package wimbledon.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import wimbledon.entity.EntityBase;

/**
 *
 * @author vrg
 * @param <E> Entity type
 */

public abstract class DAOBase<E extends EntityBase> {

    protected final EntityManager em;
    
    private final Class<E>entityType;

    public DAOBase(Class<E> entityType, EntityManager em) {
        this.em = em;
        this.entityType = entityType;
    }
    
    public E findById(Long id) {
        return em.find(entityType, id);
    }
    
    public E persist(E entity) {
        em.persist(entity);
        return entity;
    }
    
    public <T> T getFirstResult(CriteriaQuery<T> cq) {
        List<T> resultList = em.createQuery(cq).setMaxResults(1).getResultList();
        if (resultList.isEmpty()) {
            return null;
        } else {
            return resultList.get(0);
        }
    }
    
    
}
