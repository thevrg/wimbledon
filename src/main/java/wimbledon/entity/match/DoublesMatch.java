package wimbledon.entity.match;

import wimbledon.entity.team.Team;

/**
 *
 * @author vrg
 */
public class DoublesMatch extends Match {
    private Team team1;
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
