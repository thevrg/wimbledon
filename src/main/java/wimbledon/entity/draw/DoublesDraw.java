package wimbledon.entity.draw;

import wimbledon.entity.team.Team;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "DRAW_DOUBLES")
public abstract class DoublesDraw extends Draw {
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "DRAW_DOUBLES_TEAM",
            joinColumns = @JoinColumn(name = "DRAW_ID"),
            inverseJoinColumns = @JoinColumn(name = "TEAM_ID"))
    protected List<Team>registeredTeams = new ArrayList<>();
    protected DoublesDraw register(Team team) {
        registeredTeams.add(team);
        return this;
    }
}
