package backlog4j;

import java.util.Map;

/**
 * @author eguchi
 */
public final class Status {
    private final Integer id;
    private final String name;
    private final Integer count;

    public Status(Map<String, Object> map) {
        assert (map.size() > 1);
        id = (Integer) map.get("id");
        name = (String) map.get("name");
        count = (Integer) map.get("count");
    }

    public static Status create(Map<String, Object> map) {
        return map == null ? null : new Status(map);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Status{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status status = (Status) o;

        if (id != null ? !id.equals(status.id) : status.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
