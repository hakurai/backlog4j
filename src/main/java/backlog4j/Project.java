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

    public Project(Map<String, Object> src) {
        id = (Integer) src.get("id");
        name = (String) src.get("name");
        key = (String) src.get("key");
        url = (String) src.get("url");
        archived = (Boolean) src.get("archived");
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
}
