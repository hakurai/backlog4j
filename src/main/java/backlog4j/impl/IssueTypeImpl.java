package backlog4j.impl;

import backlog4j.IssueType;

import java.util.Map;

/**
 * @author eguchi
 */
public final class IssueTypeImpl implements IssueType {

    private final Integer id;
    private final String name;
    private final String color;

    public IssueTypeImpl(Map<String, Object> map) {
        assert (map.size() == 3);
        id = (Integer) map.get("id");
        name = (String) map.get("name");
        color = (String) map.get("color");

    }

    public static IssueType create(Map<String, Object> map) {
        return map == null ? null : new IssueTypeImpl(map);
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

        if (id != issueType.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
