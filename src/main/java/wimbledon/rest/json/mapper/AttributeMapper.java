package wimbledon.rest.json.mapper;

import wimbledon.rest.JsonObjectBuilder;


/**
 *
 * @author vrg
 */
@FunctionalInterface
public interface AttributeMapper<E> {
    
    void mapAttribute(JsonObjectBuilder builder, E entity);
    
}
