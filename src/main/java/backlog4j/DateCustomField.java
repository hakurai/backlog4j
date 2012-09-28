package backlog4j;

/**
 * @author eguchi
 */
public interface DateCustomField extends CustomField {

    public enum InitialValueType {
        CURRENT(1),
        SHIFT(2),
        DESIGNATED(3);

        private final int id;

        private InitialValueType(int id) {
            this.id = id;
        }

        public static InitialValueType valueOf(int id) {
            switch (id) {
                case 1:
                    return CURRENT;
                case 2:
                    return SHIFT;
                case 3:
                    return DESIGNATED;
                default:
                    throw new IllegalArgumentException("Illegal id : " + id);

            }
        }
    }

    InitialValueType getInitialValueType();

    Integer getInitialShift();

    String getInitialDate();

    String getMin();

    String getMax();
}
