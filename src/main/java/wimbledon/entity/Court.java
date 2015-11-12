package wimbledon.entity;

import javax.persistence.Entity;

/**
 *
 * @author vrg
 */
@Entity
public class Court extends EntityBase {

    private String name;

    public Court() {
    }

    public Court(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Court{" + "name=" + name + '}';
    }
}
