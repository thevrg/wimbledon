package wimbledon.entity.match;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import wimbledon.entity.team.Team;

/**
 *
 * @author vrg
 */
@Entity
@DiscriminatorValue("D")
@Table(name = "MATCH_DOUBLES")
public class DoublesMatch extends Match {
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Team team1;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Team team2;

    public DoublesMatch() {
    }

    public DoublesMatch(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    @Override
    public String getPartiesInfo() {
        return team1 + " vs " + team2;
    }
    
    
}
