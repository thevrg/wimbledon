package wimbledon.entity.draw.doubles;

import javax.persistence.Entity;
import wimbledon.entity.DrawType;
import wimbledon.entity.draw.DoublesDraw;
import wimbledon.entity.team.MensDoublesTeam;

/**
 *
 * @author vrg
 */
@Entity
public class MensDoublesDraw extends DoublesDraw {

    public MensDoublesDraw register(MensDoublesTeam team) {
        super.register(team);
        return this;
    }

    @Override
    public DrawType getType() {
        return DrawType.MENS_DOUBLE;
    }

    
}
