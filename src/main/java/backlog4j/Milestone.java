package backlog4j;

import java.util.Map;

/**
 * @author eguchi
 */
public final class Milestone {

    private final Integer id;
    private final String name;
    private final String date;

    public Milestone(Map<String, Object> map) {
        assert (map.size() == 3);
        id = (Integer) map.get("id");
        name = (String) map.get("name");
        date = (String) map.get("date");
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Milestone{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
