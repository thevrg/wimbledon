package wimbledon.rest.json.mapper;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import wimbledon.rest.NullAccepterJsonObjectBuilder;
import java.util.function.Function;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import wimbledon.entity.EntityBase;
import wimbledon.rest.JsonObjectBuilder;

/**
 *
 * @author vrg
 */
public class EntityBaseMapper<E extends EntityBase> implements Function<E, JsonObject>, BiConsumer<JsonArrayBuilder, E>{
    protected final JsonObjectBuilder builder;

    private final Map<String,AttributeMapper<E>>attributeMappers = new HashMap<>();
    
    protected void add(String name, AttributeMapper<E> task) {
        attributeMappers.put(name, task);
    }
    
    protected void addBasic(String name, BiConsumer<JsonObjectBuilder, E> adder) {
        add(name, new BasicAttributeMapperTask<>(adder));
    }
    
    protected <CE> void addCollection(String name, String targetName, CollectionGetter<E,CE>collectionGetter, BiConsumer<JsonArrayBuilder, CE> adder) {
        add(name, new CollectionMapperTask<>(targetName, collectionGetter,adder));
    }
    protected <CE> void addCollection(String name, CollectionGetter<E,CE>collectionGetter, BiConsumer<JsonArrayBuilder, CE> adder) {
        add(name, new CollectionMapperTask<>(name, collectionGetter,adder));
    }
    
    protected void remove(String name) {
        attributeMappers.remove(name);
    }
    
    public EntityBaseMapper() {
        this.builder = new NullAccepterJsonObjectBuilder();
    }

    @Override
    public JsonObject apply(E entity) {
        attributeMappers.entrySet().stream().forEach((Map.Entry<String,AttributeMapper<E>> entry) -> {
            entry.getValue().mapAttribute(builder, entity);
        });
        return builder.build();
    }
    
    protected EntityBaseMapper withAllBasic() {
        addBasic("id", (JsonObjectBuilder builder, E entity)-> builder.add("id", entity.getId()));
        addBasic("version", (JsonObjectBuilder builder, E entity)-> builder.add("version", entity.getVersion()));
        return this;
    }
    
    public EntityBaseMapper without(String name) {
        remove(name);
        return this;
    }

    @Override
    public void accept(JsonArrayBuilder arrayBuilder, E entity) {
        arrayBuilder.add(apply(entity));
                
    }
    
}
