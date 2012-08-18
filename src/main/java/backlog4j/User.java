package backlog4j;

import java.util.Map;

/**
 * @author eguchi
 */
public final class User {

    private final int id;
    private final String name;

    public User(Map<String, Object> map) {
        assert (map.size() == 2);
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
