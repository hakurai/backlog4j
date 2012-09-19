package backlog4j.xmlrpc.reader;

import backlog4j.BacklogException;

/**
 * @author eguchi
 */
public class IntegerReader extends ObjectReader<Integer> {

    private Integer value;

    @Override
    public void read(String source) {
        try {
            value = Integer.valueOf(source.trim());
        } catch (NumberFormatException e) {
            throw new BacklogException("Failed to read value : " + source);
        }
    }

    @Override
    public Integer getObject() {
        return value;
    }
}
