package wimbledon.entity;

/**
 *
 * @author vrg
 */
public enum Gender {
    MALE('M'),
    FEMALE('F');
    
    private final char code;

    private Gender(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public static Gender getGender(char code) {
        switch(code) {
            case 'M': return MALE;
            case 'F': return FEMALE;
            default: return null;
        }
    } 
}
