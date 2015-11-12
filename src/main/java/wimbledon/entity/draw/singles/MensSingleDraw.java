package wimbledon.entity.draw.singles;

import wimbledon.entity.DrawType;
import wimbledon.entity.Gender;
import wimbledon.entity.draw.SingleDraw;
import wimbledon.entity.player.Player;

/**
 *
 * @author vrg
 */
public class MensSingleDraw extends SingleDraw {

    @Override
    public void register(Player player) throws IllegalArgumentException {
        if (player.getGender() != Gender.MALE) {
            throw new IllegalArgumentException("Just male players allowed in this type of draw.");
        }
        super.register(player);
    }

    @Override
    public DrawType getType() {
        return DrawType.MENS_SINGLE;
    }

}
