package wimbledon.entity.draw.doubles;

import javax.persistence.Entity;
import wimbledon.entity.DrawType;
import wimbledon.entity.draw.DoublesDraw;
import wimbledon.entity.team.WomensDoublesTeam;

/**
 *
 * @author vrg
 */
@Entity
public class WomensDoublesDraw extends DoublesDraw {

    protected void register(WomensDoublesTeam team) {
        super.register(team);
    }

    @Override
    public DrawType getType() {
        return DrawType.WOMENS_DOUBLE;
    }

}
