/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wimbledon.rest.json.mapper;

import java.net.URI;
import java.util.function.BiConsumer;
import java.util.function.Function;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import wimbledon.entity.EntityBase;

/**
 *
 * @author vrg
 */
public class EntityUriMapper<E extends EntityBase> implements Function<E, String>, BiConsumer<JsonArrayBuilder, E> {

    private UriInfo uriInfo;
    private Class<?>resourceClass;

    public EntityUriMapper(UriInfo uriInfo, Class<?> resourceClass) {
        this.uriInfo = uriInfo;
        this.resourceClass = resourceClass;
    }

    public URI getURIOf(E entity) {
        return uriInfo.getBaseUriBuilder()
                .path(resourceClass).path("{id}")
                .build(entity.getId());
    }
    
    @Override
    public String apply(E entity) {
        return getURIOf(entity).toString();
    }

    @Override
    public void accept(JsonArrayBuilder arrayBuilder, E entity) {
        arrayBuilder.add(apply(entity));
    }
    
}
