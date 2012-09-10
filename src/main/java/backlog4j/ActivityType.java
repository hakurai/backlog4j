package backlog4j;

import java.util.Map;

/**
 * @author eguchi
 */
public final class ActivityType {

    private final Integer id;
    private final String name;


    public ActivityType(Map<String, Object> map) {
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
        return "ActivityType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityType that = (ActivityType) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
