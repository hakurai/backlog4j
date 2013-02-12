package backlog4j;

import java.util.List;

/**
 * @author eguchi
 */
public interface CustomField extends Identifired, Named {

    public enum Type {
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

        public int getId() {
            return id;
        }

        public static Type valueOf(int id) {
            switch (id) {
                case 1:
                    return STRING;
                case 2:
                    return TEXT;
                case 3:
                    return NUMBER;
                case 4:
                    return DATE;
                case 5:
                    return SINGLE_LIST;
                case 6:
                    return MULTIPLE_LIST;
                case 7:
                    return CHECKBOX;
                case 8:
                    return RADIO;
                default:
                    throw new IllegalArgumentException("Illegal id : " + id);

            }
        }

    }

    Type getTypeId();

    String getDescription();

    Boolean isRequired();

    List<IssueType> getIssueTypes();
}
