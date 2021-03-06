package backlog4j.xmlrpc.writer;

import java.io.IOException;

/**
 * @author eguchi
 */
public final class IntegerWriter extends ObjectWriter {

    private static final String        NAME     = "int";
    private static final IntegerWriter INSTANCE = new IntegerWriter();

    private IntegerWriter() {
    }

    public static IntegerWriter getInstance() {
        return INSTANCE;
    }

    public void write(XmlRpcRequestWriter writer, Object value) throws IOException {
        if (value == null) {
            writer.write(NAME, "");
        } else {
            String text = value.toString();
            writer.write(NAME, text);
        }
    }


}
