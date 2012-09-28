package backlog4j.xmlrpc.reader;

import backlog4j.BacklogException;

/**
 * @author eguchi
 */
public class DoubleReader extends ObjectReader<Double> {

    private Double value;

    @Override
    public void read(String source) {
        try {
            value = Double.valueOf(source.trim());
        } catch (NumberFormatException e) {
            throw new BacklogException("Failed to read value : " + source);
        }
    }

    @Override
    public Double getObject() {
        return value;
    }
}
