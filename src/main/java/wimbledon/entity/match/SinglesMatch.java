package wimbledon.entity.match;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import wimbledon.entity.player.Player;

/**
 *
 * @author vrg
 */
@Entity
@DiscriminatorValue("S")
@Table(name = "MATCH_SINGLES")
public class SinglesMatch extends Match {
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Player player1;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Player player2;

    public SinglesMatch() {
    }

    public SinglesMatch(Player player1, Player player2) {
        Objects.requireNonNull(player1, "player1 must not be null");
        Objects.requireNonNull(player2, "player2 must not be null");
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
    
    @Override
    public String getPartiesInfo() {
        return player1.getName() + " vs " + player2.getName();
    }
}
