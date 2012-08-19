package backlog4j;

import java.util.Map;

/**
 * @author eguchi
 */
public final class Project {

    private final int id;
    private final String name;
    private final String key;
    private final String url;
    private final boolean archived;

    public Project(Map<String, Object> map) {
        assert (map.size() == 5);
        id = (Integer) map.get("id");
        name = (String) map.get("name");
        key = (String) map.get("key");
        url = (String) map.get("url");
        archived = (Boolean) map.get("archived");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public String getUrl() {
        return url;
    }

    public boolean isArchived() {
        return archived;
    }

    @Override
    public String toString() {
        return "Project{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
