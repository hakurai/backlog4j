package backlog4j.xmlrpc.reader;

/**
 * @author eguchi
 */
public class StringReader extends ObjectReader<String> {

    private String value;

    @Override
    public void read(String source) {
        value = source;
    }

    @Override
    public String getObject() {
        return value;
    }
}
