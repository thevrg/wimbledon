package wimbledon.entity.match;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import wimbledon.entity.Court;
import wimbledon.entity.Umpire;

/**
 *
 * @author vrg
 */
public abstract class Match {

    private Court court;
    private Date startTime;
    private Umpire umpire;
    private MatchStatus status;

    private List<Set> sets = new ArrayList<>();

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Umpire getUmpire() {
        return umpire;
    }

    public void setUmpire(Umpire umpire) {
        this.umpire = umpire;
    }

    public MatchStatus getStatus() {
        return status;
    }

    public void setStatus(MatchStatus status) {
        this.status = status;
    }

    public List<Set> getSets() {
        return sets;
    }

    public String getScore() {
        StringBuilder sb = new StringBuilder();
        for (Set set : sets) {
            sb.append(set);
            sb.append(" ");
        }
        return sb.toString();
    }

    public abstract String getPartiesInfo();

    @Override
    public String toString() {
        return "Match{" + "parties=" + getPartiesInfo()
                + ", status=" + status
                + ", score: " + getScore()
                + ", court=" + court
                + ", startTime=" + startTime
                + ", umpire=" + umpire + '}';
    }
}
