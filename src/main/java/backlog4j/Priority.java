package backlog4j;

import java.util.Map;

/**
 * @author eguchi
 */
public final class Priority {

    private final Integer id;
    private final String name;

    public Priority(Map<String, Object> map) {
        assert (map.size() == 2);
        id = (Integer) map.get("id");
        name = (String) map.get("name");
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Priority{" +
                "name='" + name + '\'' +
                '}';
    }
}
