package wimbledon.entity.team;

import wimbledon.entity.Gender;
import wimbledon.entity.player.Player;

/**
 *
 * @author vrg
 */
public class MensDoublesTeam extends Team {

    public MensDoublesTeam(Player player1, Player player2) throws IllegalArgumentException {
        if (player1.getGender() != Gender.MALE) {
            throw new IllegalArgumentException("Player1 is not a male");
        }
        if (player2.getGender() != Gender.MALE) {
            throw new IllegalArgumentException("Player2 is not a male");
        }
        this.player1 = player1;
        this.player2 = player2;
    }

}
