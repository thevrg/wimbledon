package wimbledon.entity.draw;

import wimbledon.entity.player.Player;
import wimbledon.entity.team.Team;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vrg
 */
public abstract class DoublesDraw extends Draw {
    protected List<Team>registeredTeams = new ArrayList<>();
    protected void register(Team team) {
        registeredTeams.add(team);
    }
}
