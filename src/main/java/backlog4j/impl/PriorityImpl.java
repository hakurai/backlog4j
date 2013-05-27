package backlog4j.impl;

import backlog4j.Priority;

import java.util.Map;

/**
 * @author eguchi
 */
public final class PriorityImpl implements Priority {

    private final Integer id;
    private final String  name;

    public PriorityImpl(Map<String, Object> map) {
        assert (map.size() == 2);
        id = (Integer) map.get("id");
        name = (String) map.get("name");
    }

    public static Priority create(Map<String, Object> map) {
        return map == null ? null : new PriorityImpl(map);
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
    public String toString() {
        return "Priority{" +
               "name='" + name + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Priority priority = (Priority) o;

        if (id != null ? !id.equals(priority.getId()) : priority.getId() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
