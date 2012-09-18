package backlog4j.impl;

import backlog4j.Project;

import java.util.Map;

/**
 * @author eguchi
 */
public final class ProjectImpl implements Project {

    private final Integer id;
    private final String name;
    private final String key;
    private final String url;
    private final Boolean archived;

    public ProjectImpl(Map<String, Object> map) {
        assert (map.size() == 5);
        id = (Integer) map.get("id");
        name = (String) map.get("name");
        key = (String) map.get("key");
        url = (String) map.get("url");
        archived = (Boolean) map.get("archived");
    }

    public static Project create(Map<String, Object> map) {
        return map == null ? null : new ProjectImpl(map);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public Boolean isArchived() {
        return archived;
    }

    @Override
    public String toString() {
        return "Project{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (id != null ? !id.equals(project.getId()) : project.getId() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
