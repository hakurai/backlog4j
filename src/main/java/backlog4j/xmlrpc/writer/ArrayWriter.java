package backlog4j.xmlrpc.writer;

import java.io.IOException;

/**
 * @author eguchi
 */
public final class ArrayWriter extends ObjectWriter {

    private static final String NAME = "array";
    private static final ArrayWriter INSTANCE = new ArrayWriter();

    private ArrayWriter() {
    }

    public static ArrayWriter getInstance() {
        return INSTANCE;
    }

    public void write(XmlRpcRequestWriter writer, Object value) throws IOException {
        writer.writeTagStart(NAME);
        writer.writeTagStart("data");
        if (value != null) {
            writeArray(writer, (Object[]) value);
        }
        writer.writeTagEnd("data");
        writer.writeTagEnd(NAME);

    }

    private void writeArray(XmlRpcRequestWriter writer, Object[] array) throws IOException {
        if (array.length == 0) {
            return;
        }

        for (Object obj : array) {
            writer.writeObject(obj);
        }
    }


}
