package wimbledon.entity.draw;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import wimbledon.entity.Court;
import wimbledon.entity.DrawType;
import wimbledon.entity.Round;
import wimbledon.entity.Umpire;

/**
 *
 * @author vrg
 */
public abstract class Draw {
    private String name;
    private Date startDate;
    private Date endDate;

    private Map<Integer,Round>rounds = new HashMap<>();
    private List<Court>availableCourts = new ArrayList<>();
    private List<Umpire>availableUmpires = new ArrayList<>();
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

    public void replaceRound(Round round) {
        this.rounds.put(round.getNumber(), round);
    }

    public List<Court> getAvailableCourts() {
        return availableCourts;
    }

    public void setAvailableCourts(List<Court> availableCourts) {
        this.availableCourts = availableCourts;
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
