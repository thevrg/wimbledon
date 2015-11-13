package wimbledon.entity.player;

/**
 *
 * @author vrg
 */
public class PlayerBuilder {

    private Player p = new Player();
    
    public PlayerBuilder id(Long id) {
        p.setId(id);
        return this;
    }

    public PlayerBuilder name(String name) {
        p.setName(name);
        return this;
    }

    public PlayerBuilder version(Long version) {
        p.setVersion(version);
        return this;
    }

    public Player build() {
        return p;
    }
}
