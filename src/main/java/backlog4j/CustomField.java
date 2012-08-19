package backlog4j;

/**
 * @author eguchi
 */
public interface CustomField {

    public enum Type{
        UNDEFINED(0),
        STRING(1),
        TEXT(2),
        NUMBER(3),
        DATE(4),
        SINGLE_LIST(5),
        MULTIPLE_LIST(6),
        CHECKBOX(7),
        RADIO(8);

        private final int id;

        private Type(int id) {
            this.id = id;
        }
    }
}
