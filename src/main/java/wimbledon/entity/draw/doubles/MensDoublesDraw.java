package wimbledon.entity.draw.doubles;

import wimbledon.entity.DrawType;
import wimbledon.entity.draw.DoublesDraw;
import wimbledon.entity.team.MensDoublesTeam;

/**
 *
 * @author vrg
 */
public class MensDoublesDraw extends DoublesDraw {

    protected void register(MensDoublesTeam team) {
        super.register(team);
    }

    @Override
    public DrawType getType() {
        return DrawType.MENS_DOUBLE;
    }
    
}
