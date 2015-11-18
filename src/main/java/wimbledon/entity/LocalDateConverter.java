package wimbledon.entity;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author vrg
 */
@Converter(autoApply = true)

public class LocalDateConverter implements AttributeConverter<LocalDate, java.sql.Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate attribute) {
        return attribute == null ? null : Date.valueOf(attribute);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date dbData) {
        if (dbData == null) {
            return null;
        }
        Instant instant = Instant.ofEpochMilli(dbData.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
    }

}
