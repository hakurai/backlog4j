package backlog4j.impl;

import backlog4j.User;

import java.util.Map;

/**
 * @author eguchi
 */
public final class UserImpl implements User {

    private final Integer id;
    private final String name;
    private final String lang;
    private final String updatedOn;

    public UserImpl(Map<String, Object> map) {
        assert (map.size() > 1);
        id = (Integer) map.get("id");
        name = (String) map.get("name");
        lang = (String) map.get("lang");
        updatedOn = (String) map.get("updated_on");
    }

    public static User create(Map<String, Object> map) {
        return map == null ? null : new UserImpl(map);
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
    public String getLang() {
        return lang;
    }

    @Override
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

        if (id != null ? !id.equals(user.getId()) : user.getId() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
