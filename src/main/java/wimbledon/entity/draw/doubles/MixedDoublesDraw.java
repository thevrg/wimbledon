package wimbledon.entity.draw.doubles;

import javax.persistence.Entity;
import wimbledon.entity.DrawType;
import wimbledon.entity.draw.DoublesDraw;
import wimbledon.entity.team.MixedDoublesTeam;

/**
 *
 * @author vrg
 */
@Entity
public class MixedDoublesDraw extends DoublesDraw {

    protected void register(MixedDoublesTeam team) {
        super.register(team);
    }
    
    @Override
    public DrawType getType() {
        return DrawType.MIXED_DOUBLE;
    }
}
