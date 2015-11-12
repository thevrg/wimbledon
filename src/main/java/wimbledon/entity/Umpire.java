package wimbledon.entity;

/**
 *
 * @author vrg
 */
public class Umpire {
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
