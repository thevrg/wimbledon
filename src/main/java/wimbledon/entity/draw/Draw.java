package wimbledon.entity.draw;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import wimbledon.entity.Court;
import wimbledon.entity.DrawType;
import wimbledon.entity.EntityBase;
import wimbledon.entity.Round;
import wimbledon.entity.Umpire;

/**
 *
 * @author vrg
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Draw extends EntityBase {

    private String name;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endDate;

    @OneToMany(mappedBy = "draw", cascade = CascadeType.PERSIST)
    @MapKey(name = "number")
    private Map<Integer, Round> rounds = new HashMap<>();
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(joinColumns = @JoinColumn(name = "DRAW_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURT_ID"))
    private List<Court> availableCourts = new ArrayList<>();
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(joinColumns = @JoinColumn(name = "DRAW_ID"),
            inverseJoinColumns = @JoinColumn(name = "UMPIRE_ID"))
    private List<Umpire> availableUmpires = new ArrayList<>();

    public abstract DrawType getType();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Round getRound(int number) {
        return rounds.get(number);
    }

    public Draw replaceRound(Round round) {
        this.rounds.put(round.getNumber(), round);
        round.setDraw(this);
        return this;
    }

    public List<Court> getAvailableCourts() {
        return availableCourts;
    }

    public void setAvailableCourts(List<Court> availableCourts) {
        this.availableCourts = availableCourts;
    }

    public Draw addCourt(Court court) {
        availableCourts.add(court);
        return this;
    }

    public Draw addUpire(Umpire umpire) {
        availableUmpires.add(umpire);
        return this;
    }

    public List<Umpire> getAvailableUmpires() {
        return availableUmpires;
    }

    public void setAvailableUmpires(List<Umpire> availableUmpires) {
        this.availableUmpires = availableUmpires;
    }

    @Override
    public String toString() {
        return "Draw{" + "name=" + name + ", type=" + getType() + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }

}
