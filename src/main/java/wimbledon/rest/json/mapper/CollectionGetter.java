package wimbledon.rest.json.mapper;

import java.util.List;

/**
 *
 * @author vrg
 */
@FunctionalInterface
public interface CollectionGetter<E,CE> {
    public List<CE> getCollection(E entity);
}
