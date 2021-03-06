package wimbledon.entity.match;

import java.util.Objects;
import wimbledon.entity.player.Player;

/**
 *
 * @author vrg
 */
public class SinglesMatch extends Match {
    private Player player1;
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
