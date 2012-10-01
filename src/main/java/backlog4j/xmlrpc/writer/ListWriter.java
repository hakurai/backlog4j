package backlog4j.xmlrpc.writer;

import java.io.IOException;
import java.util.List;

/**
 * @author eguchi
 */
public final class ListWriter extends ObjectWriter {

    private static final String NAME = "array";
    private static final ListWriter INSTANCE = new ListWriter();

    private ListWriter() {
    }

    public static ListWriter getInstance() {
        return INSTANCE;
    }

    public void write(XmlRpcRequestWriter writer, Object value) throws IOException {
        writer.writeTagStart(NAME);
        writer.writeTagStart("data");
        if (value != null) {
            writeArray(writer, (List<Object>) value);
        }
        writer.writeTagEnd("data");
        writer.writeTagEnd(NAME);

    }

    private void writeArray(XmlRpcRequestWriter writer, List<Object> array) throws IOException {
        if (array.isEmpty()) {
            return;
        }

        for (Object obj : array) {
            writer.writeObject(obj);
        }
    }


}
