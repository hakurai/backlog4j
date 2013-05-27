package backlog4j.xmlrpc.writer;

import java.io.IOException;

/**
 * @author eguchi
 */
public final class StringWriter extends ObjectWriter {

    private static final String       NAME     = "string";
    private static final StringWriter INSTANCE = new StringWriter();

    private StringWriter() {
    }

    public static StringWriter getInstance() {
        return INSTANCE;
    }

    public void write(XmlRpcRequestWriter writer, Object value) throws IOException {
        writer.write(NAME, value == null ? "" : value.toString());
    }
}
