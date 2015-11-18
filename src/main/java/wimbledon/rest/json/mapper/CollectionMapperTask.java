package wimbledon.rest.json.mapper;

import java.util.function.BiConsumer;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import wimbledon.rest.JsonObjectBuilder;

/**
 *
 * @author vrg
 */

public class CollectionMapperTask<E,CE> implements AttributeMapper<E>{
    private final String targetName;
    private final CollectionGetter<E,CE>collectionGetter;
    private final BiConsumer<JsonArrayBuilder,CE>adder;

    public CollectionMapperTask(String targetName, CollectionGetter<E,CE> getCollectionFunction, BiConsumer<JsonArrayBuilder, CE> adder) {
        this.targetName = targetName;
        this.collectionGetter = getCollectionFunction;
        this.adder = adder;
    }

    public String getTargetName() {
        return targetName;
    }

    public CollectionGetter<E, CE> getCollectionGetter() {
        return collectionGetter;
    }

    public BiConsumer<JsonArrayBuilder, CE> getAdder() {
        return adder;
    }
    
    @Override
    public void mapAttribute(JsonObjectBuilder builder, E entity) {
        JsonArray array = collectionGetter
                .getCollection(entity)
                .stream()
                .collect(JSONUtil.toJsonArray(adder));
        builder.add(targetName, array);
    }
}
