package wimbledon.entity.team;

import java.util.Objects;
import wimbledon.entity.Gender;
import wimbledon.entity.player.Player;

/**
 *
 * @author vrg
 */
public class WomensDoublesTeam extends Team {

    public WomensDoublesTeam(Player player1, Player player2) throws IllegalArgumentException {
        Objects.requireNonNull(player1, "player1 must not be null");
        Objects.requireNonNull(player2, "player2 must not be null");
        if (player1.getGender() != Gender.FEMALE) {
            throw new IllegalArgumentException("Player1 is not a female");
        }
        if (player2.getGender() != Gender.FEMALE) {
            throw new IllegalArgumentException("Player2 is not a female");
        }
        this.player1 = player1;
        this.player2 = player2;
    }

}
