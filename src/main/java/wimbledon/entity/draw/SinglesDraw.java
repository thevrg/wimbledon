package wimbledon.entity.draw;

import wimbledon.entity.player.Player;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author vrg
 */
@Entity
@Table(name = "DRAW_SINGLES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class SinglesDraw extends Draw {
    @OneToMany
    @JoinTable(name = "DRAW_SINGLES_PLAYER",
            joinColumns = @JoinColumn(name = "DRAW_ID"),
            inverseJoinColumns = @JoinColumn(name = "PLAYER_ID"))
    protected List<Player>registeredPlayers = new ArrayList<>();
    protected void register(Player player) {
        registeredPlayers.add(player);
    }
}
