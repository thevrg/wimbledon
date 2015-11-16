package wimbledon.entity.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import wimbledon.entity.EntityBase;
import wimbledon.entity.Gender;

/**
 *
 * @author vrg
 */
@Entity
public class Player extends EntityBase {

    private String name;
    @Column(columnDefinition = "char(1)")
    private Gender gender;

    public Player() {
    }

    public Player(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", gender=" + gender + '}';
    }

    public static PlayerBuilder builder() {
        return new PlayerBuilder();
    }

}
