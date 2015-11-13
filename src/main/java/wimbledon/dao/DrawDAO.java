package wimbledon.dao;

import javax.persistence.EntityManager;
import wimbledon.dao.criteria.DrawCriteriaBuilder;
import wimbledon.entity.draw.Draw;

/**
 *
 * @author vrg
 */
public class DrawDAO extends DAOBase<Draw>{

    public DrawDAO(EntityManager em) {
        super(Draw.class, em);
    }
    public Draw findByName(String name) {
        return getFirstResult(
                new DrawCriteriaBuilder(em)
                        .nameEqualsTo(name)
                        .build());
    }
}
