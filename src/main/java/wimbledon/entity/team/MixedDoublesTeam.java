package wimbledon.entity.team;

import java.util.Objects;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import wimbledon.entity.Gender;
import wimbledon.entity.player.Player;

/**
 *
 * @author vrg
 */
@Entity
@DiscriminatorValue("MIX")
public class MixedDoublesTeam extends Team {

    public MixedDoublesTeam() {
    }

    public MixedDoublesTeam(Player femalePlayer, Player malePlayer) throws IllegalArgumentException {
        Objects.requireNonNull(femalePlayer, "femalePlayer must not be null");
        Objects.requireNonNull(malePlayer, "malePlayer must not be null");
        if (femalePlayer.getGender() != Gender.FEMALE) {
            throw new IllegalArgumentException("Player1 is not a female");
        }
        if (malePlayer.getGender() != Gender.MALE) {
            throw new IllegalArgumentException("Player2 is not a male");
        }
        this.player1 = femalePlayer;
        this.player2 = malePlayer;
    }

}
