package backlog4j;

import java.util.Map;

/**
 * @author eguchi
 */
public final class IssueType {

    private final int id;
    private final String name;
    private final String color;

    public IssueType(Map<String, Object> map) {
        assert (map.size() == 3);
        id = (Integer) map.get("id");
        name = (String) map.get("name");
        color = (String) map.get("color");

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "IssueType{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IssueType issueType = (IssueType) o;

        if (id != issueType.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
