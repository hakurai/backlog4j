package backlog4j;

import java.util.Map;

/**
 * @author eguchi
 */
public final class Category {

    private final int id;
    private final String name;

    public Category(Map<String,Object> map) {
        id = (Integer)map.get("id");
        name = (String)map.get("name");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
