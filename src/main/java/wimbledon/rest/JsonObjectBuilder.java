package wimbledon.rest;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author vrg
 */
public interface JsonObjectBuilder extends javax.json.JsonObjectBuilder {

    JsonObjectBuilder add(String name, LocalDate date);

    JsonObjectBuilder add(String name, LocalDateTime date);
    
}
