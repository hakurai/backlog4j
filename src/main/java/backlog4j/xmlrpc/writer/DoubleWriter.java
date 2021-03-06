package backlog4j.xmlrpc.writer;

import java.io.IOException;

/**
 * @author eguchi
 */
public final class DoubleWriter extends ObjectWriter {

    private static final String       NAME     = "double";
    private static final DoubleWriter INSTANCE = new DoubleWriter();

    private DoubleWriter() {
    }

    public static DoubleWriter getInstance() {
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
