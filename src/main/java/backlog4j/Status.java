package backlog4j;

import java.util.Map;

/**
 * @author eguchi
 */
public final class Status {
    private final int id;
    private final String name;

    public Status(Map<String, Object> map) {
        assert (map.size() == 2);
        id = (Integer) map.get("id");
        name = (String) map.get("name");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Status{" +
                "name='" + name + '\'' +
                '}';
    }
}
