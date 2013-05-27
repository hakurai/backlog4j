package backlog4j.xmlrpc.writer;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @author eguchi
 */
public class MapWriter extends ObjectWriter {

    private static final String    NAME     = "struct";
    private static final MapWriter INSTANCE = new MapWriter();

    private MapWriter() {
    }

    public static MapWriter getInstance() {
        return INSTANCE;
    }

    @Override
    public void write(XmlRpcRequestWriter writer, Object value) throws IOException {
        writer.writeTagStart(NAME);
        writeMembers(writer, (Map<String, Object>) value);
        writer.writeTagEnd(NAME);

    }

    private void writeMembers(XmlRpcRequestWriter writer, Map<String, Object> value) throws IOException {
        Set<Map.Entry<String, Object>> entrySet = value.entrySet();

        for (Map.Entry<String, Object> entry : entrySet) {
            writeMember(writer, entry);
        }
    }

    private void writeMember(XmlRpcRequestWriter writer, Map.Entry<String, Object> entry) throws IOException {
        writer.writeTagStart("member");
        writer.write("name", entry.getKey());
        writer.writeObject(entry.getValue());
        writer.writeTagEnd("member");

    }
}
