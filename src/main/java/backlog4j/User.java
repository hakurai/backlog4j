package backlog4j;

import java.util.Map;

/**
 * @author eguchi
 */
public final class User {

    private final Integer id;
    private final String name;
    private final String lang;
    private final String updatedOn;

    public User(Map<String, Object> map) {
        assert (map.size() > 1);
        id = (Integer) map.get("id");
        name = (String) map.get("name");
        lang = (String) map.get("lang");
        updatedOn = (String) map.get("updated_on");
    }

    public static User create(Map<String, Object> map) {
        return map == null ? null : new User(map);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLang() {
        return lang;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
