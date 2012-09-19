package backlog4j.impl;

import backlog4j.Version;

import java.util.Map;

/**
 * @author eguchi
 */
public final class VersionImpl implements Version {

    private final Integer id;
    private final String name;
    private final String date;


    public VersionImpl(Map<String, Object> map) {
        assert (map.size() == 3);
        id = (Integer) map.get("id");
        name = (String) map.get("name");
        date = (String) map.get("date");
    }

    public static Version create(Map<String, Object> map) {
        return map == null ? null : new VersionImpl(map);
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
    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Version{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Version version = (Version) o;

        if (id != version.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
