package wimbledon.entity.team;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    protected Player player1;
    @ManyToOne(cascade = CascadeType.PERSIST)
    protected Player player2;

    protected Team() {
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    @Override
    public String toString() {
        return "Team{" + "player1=" + player1 + ", player2=" + player2 + '}';
    }
}
