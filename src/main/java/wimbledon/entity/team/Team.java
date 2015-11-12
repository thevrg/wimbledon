package wimbledon.entity.team;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import wimbledon.entity.EntityBase;
import wimbledon.entity.player.Player;

/**
 *
 * @author vrg
 */
@Entity
@Inheritance
@DiscriminatorColumn(length = 3)
public abstract class Team extends EntityBase {

    protected Player player1;
    protected Player player2;

    protected Team() {
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

}
