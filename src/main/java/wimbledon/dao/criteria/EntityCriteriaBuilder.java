/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wimbledon.dao.criteria;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import wimbledon.entity.EntityBase;

/**
 *
 * @author vrg
 */
public abstract class EntityCriteriaBuilder<E extends EntityBase> {
    protected final CriteriaBuilder cb;
    protected final Class<E>entityType;
    protected final CriteriaQuery<E>query;
    protected List<Predicate>predicateList = new ArrayList<>();
    protected final Root<E>root;
    

    public EntityCriteriaBuilder(Class<E> entityType, EntityManager em) {
        this.cb = em.getCriteriaBuilder();
        this.entityType = entityType;
        this.query = cb.createQuery(entityType);
        this.root = query.from(entityType);
    }
    
    protected EntityCriteriaBuilder<E> addPredicate(Predicate predicate) {
        predicateList.add(predicate);
        return this;
    }
    
    public CriteriaQuery<E>build() {
        query.where(predicateList.toArray(new Predicate[predicateList.size()]));
        return query;
    }
    
}
