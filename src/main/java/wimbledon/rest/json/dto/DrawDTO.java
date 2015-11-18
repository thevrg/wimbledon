package wimbledon.rest.json.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import wimbledon.entity.DrawType;
import wimbledon.entity.Umpire;
import wimbledon.entity.draw.Draw;

/**
 *
 * @author vrg
 */
@XmlRootElement(name="draw")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class DrawDTO extends DTOBase<Draw> {
    public DrawDTO() {
    }

    public DrawDTO(Draw draw) {
        super(draw);
    }
    
    
    @XmlElement
    public DrawType getType() {
        return entity.getType();
    }

    @XmlElement
    public String getName() {
        return entity.getName();
    }

    @XmlElement
    public LocalDate getStartDate() {
        return entity.getStartDate();
    }

    @XmlElement
    public LocalDate getEndDate() {
        return entity.getEndDate();
    }

    @XmlElement
    public List<CourtDTO> getAvailableCourts() {
        return entity.getAvailableCourts().stream()
                .map(court -> new CourtDTO(court))
                .collect(Collectors.toList());
    }

    @XmlElement
    public List<Umpire> getAvailableUmpires() {
        return entity.getAvailableUmpires();
    }

    @XmlElement
    public Long getId() {
        return entity.getId();
    }
    
    
}
