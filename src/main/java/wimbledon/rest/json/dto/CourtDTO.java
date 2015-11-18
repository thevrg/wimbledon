package wimbledon.rest.json.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import wimbledon.entity.Court;

/**
 *
 * @author vrg
 */
@XmlRootElement
public class CourtDTO extends DTOBase<Court> {

    public CourtDTO() {
    }

    public CourtDTO(Court court) {
        super(court);
    }
    
    @XmlElement
    public String getName() {
        return entity.getName();
    }
    
}
