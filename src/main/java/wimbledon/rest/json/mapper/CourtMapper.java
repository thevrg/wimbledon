package wimbledon.rest.json.mapper;

import wimbledon.entity.Court;
import wimbledon.rest.JsonObjectBuilder;

/**
 *
 * @author vrg
 */
public class CourtMapper extends EntityBaseMapper<Court> {

    @Override
    public CourtMapper withAllBasic() {
        super.withAllBasic();
        addBasic("name", (JsonObjectBuilder builder, Court entity)
                -> builder.add("name", entity.getName()));
        return this;
    }

}
