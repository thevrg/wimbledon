package wimbledon.dao;

import wimbledon.dao.criteria.CourtCriteriaBuilder;
import javax.persistence.EntityManager;
import wimbledon.entity.Court;

/**
 *
 * @author vrg
 */
public class CourtDAO extends DAOBase<Court>{

    public CourtDAO(EntityManager em) {
        super(Court.class, em);
    }
    public Court findByName(String name) {
        return getFirstResult(
                new CourtCriteriaBuilder(em)
                        .nameEqualsTo(name)
                        .build());
    }
}
