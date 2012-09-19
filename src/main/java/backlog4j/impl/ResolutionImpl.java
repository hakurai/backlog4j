package backlog4j.impl;

import backlog4j.Resolution;

import java.util.Map;

/**
 * @author eguchi
 */
public final class ResolutionImpl implements Resolution {

    private final Integer id;
    private final String name;

    public ResolutionImpl(Map<String, Object> map) {
        assert (map.size() == 2);
        id = (Integer) map.get("id");
        name = (String) map.get("name");
    }

    public static Resolution create(Map<String, Object> map) {
        return map == null ? null : new ResolutionImpl(map);
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
        return "Resolution{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResolutionImpl that = (ResolutionImpl) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
