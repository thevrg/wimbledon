package wimbledon.rest.resource;

import wimbledon.rest.json.mapper.JSONUtil;
import wimbledon.rest.json.mapper.DrawMapper;
import com.mysema.query.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import wimbledon.entity.Court;
import wimbledon.entity.Umpire;
import wimbledon.entity.draw.QDraw;
import wimbledon.rest.json.dto.DrawDTO;
import wimbledon.rest.json.mapper.EntityUriMapper;

/**
 *
 * @author vrg
 */
@Path("/draws")
@Stateless
public class DrawResource {

    @Inject
    private JPAQueryFactory queryFactory;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DrawDTO> findAll() {
        QDraw d = new QDraw("d");
        return queryFactory
                .from(d)
                .orderBy(d.id.asc())
                .list(d).stream().map(draw -> {
            return new DrawDTO(draw);
        }).collect(Collectors.toList());
    }
    
    @GET
    @Path("json")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray findAllJSON(@Context UriInfo uriInfo) {
        System.out.println("uriInfo: " + uriInfo);
        QDraw d = new QDraw("d");
        return queryFactory
                .from(d)
                .orderBy(d.id.asc())
                .list(d).stream().map(new DrawMapper()
                        .withAllBasic()
                        .withAvailableCourts()
                        .mapAvailableCourts("availableCourtURIs",new EntityUriMapper<>(uriInfo, CourtResource.class))
                        .withAvailableUmpires()
                        .mapAvailableUmpires("umpireNames", (JsonArrayBuilder b, Umpire u) -> b.add(u.getName()))
                        .without("version")
                         )
                .collect(JSONUtil.toJsonArray());
    }
}
