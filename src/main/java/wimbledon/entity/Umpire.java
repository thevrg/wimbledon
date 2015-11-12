package wimbledon.entity;

import javax.persistence.Entity;

/**
 *
 * @author vrg
 */
@Entity
public class Umpire extends EntityBase {
    private String name;

    public Umpire() {
    }

    public Umpire(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Umpire{" + "name=" + name + '}';
    }
    
    
}
