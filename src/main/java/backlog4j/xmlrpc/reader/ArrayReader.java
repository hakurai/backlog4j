package backlog4j.xmlrpc.reader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eguchi
 */
public class ArrayReader extends ObjectReader<Object[]> {

    private final List<Object> value = new ArrayList<Object>();

    @Override
    public void read(String source) {
    }

    @Override
    public Object[] getObject() {
        return value.toArray();
    }

    @Override
    public void addObject(String name, Object obj) {
        value.add(obj);
    }
}
