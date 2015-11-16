package wimbledon.service;

import com.mysema.query.jpa.impl.JPAQueryFactory;
import javax.enterprise.inject.Produces;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vrg
 */
@Singleton
public class CDIFactory {
    @PersistenceContext
    @Produces
    private EntityManager em;
    
    @Produces
    public JPAQueryFactory createJpaQueryProducer(Provider<EntityManager>emProvider) {
        return new JPAQueryFactory(emProvider);
    }
}
