package backlog4j;

import java.util.Map;

/**
 * @author eguchi
 */
public final class Version {

    private final int id;
    private final String name;
    private final String date;


    public Version(Map<String, Object> map) {
        assert (map.size() == 3);
        id = (Integer) map.get("id");
        name = (String) map.get("name");
        date = (String) map.get("date");
    }

    public int getId() {
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

        if (id != version.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
