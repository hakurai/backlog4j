package backlog4j.xmlrpc.reader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eguchi
 */
public class StructReader extends ObjectReader<Map<String, Object>> {

    private final Map<String, Object> map = new HashMap<String, Object>();

    @Override
    public void read(String source) {

    }

    @Override
    public Map<String, Object> getObject() {
        return map;
    }

    @Override
    public void addObject(String name, Object obj) {
        map.put(name, obj);
    }
}
