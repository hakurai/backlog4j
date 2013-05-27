package backlog4j.impl;

import backlog4j.Category;

import java.util.Map;

/**
 * @author eguchi
 */
public final class CategoryImpl implements Category {

    private final Integer id;
    private final String  name;

    public CategoryImpl(Map<String, Object> map) {
        assert (map.size() == 2);
        id = (Integer) map.get("id");
        name = (String) map.get("name");
    }

    public static Category create(Map<String, Object> map) {
        return map == null ? null : new CategoryImpl(map);
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
        return "Category{" +
               "name='" + name + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
