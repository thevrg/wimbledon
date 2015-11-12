package wimbledon.entity.draw;

import wimbledon.entity.player.Player;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vrg
 */
public abstract class SingleDraw extends Draw {
    protected List<Player>registeredPlayers = new ArrayList<>();
    protected void register(Player player) {
        registeredPlayers.add(player);
    }
}
