package wimbledon.entity.match;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import wimbledon.entity.Court;
import wimbledon.entity.EntityBase;
import wimbledon.entity.Round;
import wimbledon.entity.Umpire;

/**
 *
 * @author vrg
 */
@Entity
@Table(name = "MATCH_COMMON")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.CHAR)
public abstract class Match extends EntityBase {

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Court court;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date startTime;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Umpire umpire;

    private MatchStatus status = MatchStatus.NOT_PLAYED_YET;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Round round;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "MATCH_SET", joinColumns = @JoinColumn(name = "MATCH_ID"),
            inverseJoinColumns = @JoinColumn(name = "SET_ID"))
    private List<Set> sets = new ArrayList<>();

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

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
    
    public Match addSet(Set set) {
        sets.add(set);
        return this;
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
