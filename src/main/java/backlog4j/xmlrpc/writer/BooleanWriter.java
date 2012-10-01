package backlog4j.xmlrpc.writer;

import java.io.IOException;

/**
 * @author eguchi
 */
public final class BooleanWriter extends ObjectWriter {

    private static final String NAME = "boolean";
    private static final BooleanWriter INSTANCE = new BooleanWriter();

    private BooleanWriter() {
    }

    public static BooleanWriter getInstance() {
        return INSTANCE;
    }

    public void write(XmlRpcRequestWriter writer, Object value) throws IOException {
        writer.write(NAME, value == null ? "" : (Boolean) value ? "1" : "0");
    }


}
