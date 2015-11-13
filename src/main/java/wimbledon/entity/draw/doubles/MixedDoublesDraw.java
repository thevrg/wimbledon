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

    public MixedDoublesDraw register(MixedDoublesTeam team) {
        super.register(team);
        return this;
    }
    
    @Override
    public DrawType getType() {
        return DrawType.MIXED_DOUBLE;
    }
}
