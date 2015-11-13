package wimbledon.entity.player;

import wimbledon.entity.Gender;

/**
 *
 * @author vrg
 */
public class PlayerBuilder {

    private Gender gender;
    private String name;
    private Long id;
    private Long version;
    
    public PlayerBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public PlayerBuilder name(String name) {
        this.name = name;
        return this;
    }
    public PlayerBuilder gender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public PlayerBuilder version(Long version) {
        this.version = version;
        return this;
    }

    public Player build() {
        Player p = new Player(name, gender);
        p.setId(id);
        p.setVersion(version);
        return p;
    }
}
