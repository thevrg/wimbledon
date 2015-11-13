package wimbledon.dao.criteria;

import javax.persistence.EntityManager;
import wimbledon.entity.draw.Draw;

/**
 *
 * @author vrg
 */
public class DrawCriteriaBuilder extends EntityCriteriaBuilder<Draw>{

    public DrawCriteriaBuilder(EntityManager em) {
        super(Draw.class, em);
    }
    
    public DrawCriteriaBuilder nameEqualsTo(String name) {
        addPredicate(cb.equal(root.get("name"), name));
        return this;
    }
}
