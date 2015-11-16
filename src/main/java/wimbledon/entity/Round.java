package wimbledon.entity;

import wimbledon.entity.match.Match;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Draw draw;
    
    @OneToMany(mappedBy = "round", cascade = CascadeType.PERSIST)
    private List<Match>matches = new ArrayList<>();

    public Round() {
    }

    public Round(int number) {
        this.number = number;
    }

    public Draw getDraw() {
        return draw;
    }

    public void setDraw(Draw draw) {
        this.draw = draw;
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
    
    public Round addMatch(Match match) {
        matches.add(match);
        match.setRound(this);
        return this;
    }

    @Override
    public String toString() {
        return "Round{" + "number=" + number + ", matches=" + matches + '}';
    }
}
