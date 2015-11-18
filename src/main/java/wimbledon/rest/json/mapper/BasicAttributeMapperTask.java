package wimbledon.rest.json.mapper;

import java.util.function.BiConsumer;
import wimbledon.rest.JsonObjectBuilder;

/**
 *
 * @author vrg
 */

public class BasicAttributeMapperTask<E> implements AttributeMapper<E> {
    private final BiConsumer<JsonObjectBuilder,E>adder;

    public BasicAttributeMapperTask(BiConsumer<JsonObjectBuilder, E> adder) {
        this.adder = adder;
    }

    @Override
    public void mapAttribute(JsonObjectBuilder builder, E entity) {
        adder.accept(builder, entity);
    }
}
