package backlog4j;

/**
 * @author eguchi
 */
public interface NumberCustomField extends CustomField {

    Double getMin();

    Double getMax();

    Double getInitialValue();

    String getUnit();
}
