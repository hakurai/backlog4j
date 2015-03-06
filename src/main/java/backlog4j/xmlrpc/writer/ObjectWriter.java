package backlog4j.xmlrpc.writer;

import backlog4j.BacklogException;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public abstract class ObjectWriter {

    public abstract void write(XmlRpcRequestWriter writer, Object value) throws IOException;

    public static ObjectWriter getObjectWriter(Object obj) {
        final ObjectWriter writer;

        if (obj instanceof Integer) {
            writer = IntegerWriter.getInstance();
        } else if (obj instanceof String) {
            writer = StringWriter.getInstance();
        } else if (obj instanceof Double || obj instanceof BigDecimal) {
            writer = DoubleWriter.getInstance();
        } else if (obj instanceof Boolean) {
            writer = BooleanWriter.getInstance();
        } else if (obj instanceof Object[]) {
            writer = ArrayWriter.getInstance();
        } else if (obj instanceof List) {
            writer = ListWriter.getInstance();
        } else if (obj instanceof Map) {
            writer = MapWriter.getInstance();
        } else {
            throw new BacklogException("Unsupported object type :" + obj.getClass());
        }
        return writer;
    }

}
