package wimbledon.service;

import javax.annotation.PostConstruct;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import wimbledon.entity.player.Player;

/**
 *
 * @author vrg
 */
@Singleton
@Startup
public class Initializer {
    @EJB
    private Initializer proxy;
    @PersistenceContext
    private EntityManager em;
    
    @PostConstruct
    private void init() {
        proxy.initAsync();
    }
    
    @Asynchronous
    public void initAsync() {
        em.persist(new Player());
    }
    
}
