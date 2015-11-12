package wimbledon.entity.team;

import wimbledon.entity.player.Player;

/**
 *
 * @author vrg
 */
public abstract class Team {
    protected Player player1;
    protected Player player2;

    public Team() {
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

}
