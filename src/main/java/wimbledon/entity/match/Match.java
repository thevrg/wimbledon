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
    
    private List<Set>sets = new ArrayList<>();

    public String getScore() {
        StringBuilder sb = new StringBuilder();
        for (Set set : sets) {
            sb.append(set);
            sb.append(" ");
        }
        return sb.toString();
    }
}
