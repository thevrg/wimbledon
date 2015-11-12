package wimbledon.entity;

import wimbledon.entity.match.Match;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import wimbledon.entity.draw.Draw;

/**
 *
 * @author vrg
 */
@Entity
public class Round extends EntityBase {
    private int number;
    
    @ManyToOne
    private Draw draw;
    
    @OneToMany(mappedBy = "round")
    private List<Match>matches = new ArrayList<>();

    public Round() {
    }

    public Round(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    @Override
    public String toString() {
        return "Round{" + "number=" + number + ", matches=" + matches + '}';
    }
}
