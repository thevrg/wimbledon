package wimbledon.dao.criteria;

import javax.persistence.EntityManager;
import wimbledon.entity.Court;

/**
 *
 * @author vrg
 */
public class CourtCriteriaBuilder extends EntityCriteriaBuilder<Court>{

    public CourtCriteriaBuilder(EntityManager em) {
        super(Court.class, em);
    }
    
    public CourtCriteriaBuilder nameEqualsTo(String name) {
        addPredicate(cb.equal(root.get("name"), name));
        return this;
    }
    
}
