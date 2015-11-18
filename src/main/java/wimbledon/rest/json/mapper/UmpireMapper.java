package wimbledon.rest.json.mapper;

import wimbledon.entity.Umpire;
import wimbledon.rest.JsonObjectBuilder;

/**
 *
 * @author vrg
 */
public class UmpireMapper extends EntityBaseMapper<Umpire> {

    @Override
    protected UmpireMapper withAllBasic() {
        super.withAllBasic();
        addBasic("name", (JsonObjectBuilder builder, Umpire entity)
                -> builder.add("name", entity.getName()));
        return this;
    }

}
