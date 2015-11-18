package wimbledon.rest.resource;

import wimbledon.rest.json.mapper.JSONUtil;
import com.mysema.query.jpa.impl.JPAQueryFactory;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import wimbledon.entity.Court;
import wimbledon.entity.QCourt;
import wimbledon.rest.json.mapper.CourtMapper;

/**
 *
 * @author vrg
 */
@Path("/courts")
@Stateless
public class CourtResource {

    @Inject
    private JPAQueryFactory queryFactory;
    
    @Inject
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray findAllJSON(@Context UriBuilder uriBuilder) {
        QCourt c = new QCourt("c");
        return queryFactory
                .from(c)
                .orderBy(c.id.asc())
                .list(c).stream().map(new CourtMapper()
                        .withAllBasic()
                         )
                .collect(JSONUtil.toJsonArray());
    }
    
    @GET
    @Path("{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject findById(@Context UriBuilder uriBuilder,@PathParam("id") Long id) {
        final Court entity = em.find(Court.class, id);
        return new CourtMapper()
                .withAllBasic()
                .apply(entity);
    }
}
