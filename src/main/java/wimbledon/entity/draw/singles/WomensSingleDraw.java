package wimbledon.entity.draw.singles;

import javax.persistence.Entity;
import wimbledon.entity.DrawType;
import wimbledon.entity.Gender;
import wimbledon.entity.draw.SinglesDraw;
import wimbledon.entity.player.Player;

/**
 *
 * @author vrg
 */
@Entity
public class WomensSingleDraw extends SinglesDraw {

    @Override
    public WomensSingleDraw register(Player player) throws IllegalArgumentException {
        if (player.getGender() != Gender.FEMALE) {
            throw new IllegalArgumentException("Just female players allowed in this type of draw.");
        }
        super.register(player);
        return this;
    }

    @Override
    public DrawType getType() {
        return DrawType.WOMENS_SINGLE;
    }

}
