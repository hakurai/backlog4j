package backlog4j.impl;

import backlog4j.ActivityType;

import java.util.Map;

/**
 * @author eguchi
 */
public final class ActivityTypeImpl implements ActivityType {

    private final Integer id;
    private final String  name;


    public ActivityTypeImpl(Map<String, Object> map) {
        id = (Integer) map.get("id");
        name = (String) map.get("name");
    }

    public static ActivityType create(Map<String, Object> map) {
        return map == null ? null : new ActivityTypeImpl(map);
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

        if (id != null ? !id.equals(that.getId()) : that.getId() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
