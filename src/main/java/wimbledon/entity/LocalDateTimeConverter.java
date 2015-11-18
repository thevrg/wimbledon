package wimbledon.entity;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author vrg
 */
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
        return attribute == null ? null : Timestamp.valueOf(attribute);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
        if (dbData == null) {
            return null;
        }
        Instant instant = Instant.ofEpochMilli(dbData.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

}
