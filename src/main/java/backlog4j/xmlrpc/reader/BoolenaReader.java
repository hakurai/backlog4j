package backlog4j.xmlrpc.reader;

import backlog4j.BacklogException;

/**
 * @author eguchi
 */
public class BoolenaReader extends ObjectReader<Boolean> {

    private Boolean value;

    @Override
    public void read(String source) {
        if (source.equals("0")) {
            value = Boolean.FALSE;
        } else if (source.equals("1")) {
            value = Boolean.TRUE;
        } else {
            throw new BacklogException("Failed to read value : " + source);
        }
    }

    @Override
    public Boolean getObject() {
        return value;
    }
}
