package wimbledon.entity.draw.singles;

import wimbledon.entity.DrawType;
import wimbledon.entity.Gender;
import wimbledon.entity.draw.SingleDraw;
import wimbledon.entity.player.Player;

/**
 *
 * @author vrg
 */
public class WomensSingleDraw extends SingleDraw {

    @Override
    public void register(Player player) throws IllegalArgumentException {
        if (player.getGender() != Gender.FEMALE) {
            throw new IllegalArgumentException("Just female players allowed in this type of draw.");
        }
        super.register(player);
    }

    @Override
    public DrawType getType() {
        return DrawType.WOMENS_SINGLE;
    }

}
