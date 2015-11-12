package wimbledon.entity.draw;

import java.util.Date;
import java.util.List;
import wimbledon.entity.Court;
import wimbledon.entity.DrawType;
import wimbledon.entity.Round;

/**
 *
 * @author vrg
 */
public abstract class Draw {
    private String name;
    private Date startDate;
    private Date endDate;
    private List<Round>rounds;
    private List<Court>availableCourts;
    public abstract DrawType getType();
}
