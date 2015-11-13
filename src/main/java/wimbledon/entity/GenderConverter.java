package wimbledon.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author vrg
 */
@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, Character> {

    @Override
    public Character convertToDatabaseColumn(Gender attribute) {
        return attribute.getCode();
    }

    @Override
    public Gender convertToEntityAttribute(Character dbData) {
        return Gender.getGender(dbData);
    }
}
