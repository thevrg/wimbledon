package wimbledon.entity;

/**
 *
 * @author vrg
 */
public class Court {

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
