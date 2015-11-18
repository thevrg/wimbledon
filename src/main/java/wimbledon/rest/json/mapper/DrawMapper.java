package wimbledon.rest.json.mapper;

import java.util.function.BiConsumer;
import java.util.function.Function;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import wimbledon.entity.Court;
import wimbledon.entity.Umpire;
import wimbledon.entity.draw.Draw;
import wimbledon.rest.JsonObjectBuilder;

/**
 *
 * @author vrg
 */
public class DrawMapper extends EntityBaseMapper<Draw> {

    private Function<Court,JsonObject>availableCourtsMapper;
    private Function<Umpire,JsonObject>availableUmpiresMapper;
    private Function<JsonObjectBuilder,Umpire>availableUmpiresCustomMapper;

    @Override
    public DrawMapper without(String name) {
        super.without(name);
        return this;
    }
    
    public DrawMapper withAvailableCourts() {
        addCollection("availableCourts", 
                (Draw draw) -> draw.getAvailableCourts(), 
                new CourtMapper().withAllBasic());
        return this;
    }
    
    public DrawMapper mapAvailableCourts(String targetName, BiConsumer<JsonArrayBuilder,Court>adder) {
        addCollection(targetName, 
                (Draw draw) -> draw.getAvailableCourts(), 
                adder);
        return this;
    }
    
    public DrawMapper withAvailableUmpires() {
        addCollection("availableUmpires", 
                (Draw draw) -> draw.getAvailableUmpires(), 
                new UmpireMapper().withAllBasic());
        return this;
    }
    
    public DrawMapper mapAvailableUmpires(String targetName, BiConsumer<JsonArrayBuilder,Umpire>adder) {
        addCollection(targetName, 
                (Draw draw) -> draw.getAvailableUmpires(), 
                adder);
        return this;
    }

    @Override
    public DrawMapper withAllBasic() {
        super.withAllBasic();
        addBasic("name", (JsonObjectBuilder builder, Draw entity)-> builder.add("name", entity.getName()));
        addBasic("type", (JsonObjectBuilder builder, Draw entity)-> builder.add("type", String.valueOf(entity.getType())));
        addBasic("startDate", (JsonObjectBuilder builder, Draw entity)-> builder.add("startDate", entity.getStartDate()));
        return this;
    }

}
