package wimbledon.rest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonValue;

/**
 *
 * @author vrg
 */
public class NullAccepterJsonObjectBuilder implements JsonObjectBuilder {

    private final javax.json.JsonObjectBuilder orig;

    public NullAccepterJsonObjectBuilder() {
        this.orig = Json.createObjectBuilder();
    }

    public NullAccepterJsonObjectBuilder(JsonObjectBuilder orig) {
        this.orig = orig;
    }

    @Override
    public JsonObjectBuilder add(String name, JsonValue value) {
        if (value != null) {
            orig.add(name, value);
        }
        return this;
    }

    @Override
    public JsonObjectBuilder add(String name, String value) {
        if (value != null) {
            orig.add(name, value);
        }
        return this;
    }

    @Override
    public JsonObjectBuilder add(String name, BigInteger value) {
        if (value != null) {
            orig.add(name, value);
        }
        return this;
    }

    @Override
    public JsonObjectBuilder add(String name, BigDecimal value) {
        if (value != null) {
            orig.add(name, value);
        }
        return this;
    }

    @Override
    public JsonObjectBuilder add(String name, int value) {
        orig.add(name, value);
        return this;
    }

    @Override
    public JsonObjectBuilder add(String name, long value) {
        orig.add(name, value);
        return this;
    }

    @Override
    public JsonObjectBuilder add(String name, double value) {
        orig.add(name, value);
        return this;
    }

    @Override
    public JsonObjectBuilder add(String name, boolean value) {
        orig.add(name, value);
        return this;
    }

    @Override
    public JsonObjectBuilder addNull(String name) {
        orig.addNull(name);
        return this;
    }

    @Override
    public JsonObjectBuilder add(String name, javax.json.JsonObjectBuilder builder) {
        if (builder != null) {
            orig.add(name, builder);
        }
        return this;
    }

    @Override
    public JsonObjectBuilder add(String name, JsonArrayBuilder builder) {
        if (builder != null) {
            orig.add(name, builder);
        }
        return this;
    }
    
    public JsonObjectBuilder add(String name, LocalDateTime date) {
        if (date != null) {
            orig.add(name, DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(date));
        }
        return this;
    }
    
    public JsonObjectBuilder add(String name, LocalDate date) {
        if (date != null) {
            orig.add(name, DateTimeFormatter.ISO_LOCAL_DATE.format(date));
        }
        return this;
    }

    @Override
    public JsonObject build() {
        return orig.build();
    }

}
