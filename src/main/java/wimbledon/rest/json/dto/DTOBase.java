package wimbledon.rest.json.dto;

import javax.xml.bind.annotation.XmlElement;
import wimbledon.entity.EntityBase;

/**
 *
 * @author vrg
 */
public class DTOBase<E extends EntityBase> {

    protected E entity;
    
    public DTOBase() {
    }

    public DTOBase(E base) {
        this.entity = base;
    }

    @XmlElement
    public Long getId() {
        return entity.getId();
    }

    @XmlElement
    public Long getVersion() {
        return entity.getVersion();
    }
}
