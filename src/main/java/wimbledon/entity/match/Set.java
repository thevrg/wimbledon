package wimbledon.entity.match;

import javax.persistence.Entity;
import javax.persistence.Table;
import wimbledon.entity.EntityBase;

/**
 *
 * @author vrg
 */
@Entity
@Table(name = "SET_SCORES")
public class Set extends EntityBase {

    private int score1;
    private int score2;

    public Set() {
    }

    public Set(int score1, int score2) {
        this.score1 = score1;
        this.score2 = score2;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    @Override
    public String toString() {
        return score1 + "-" + score2;
    }
}
