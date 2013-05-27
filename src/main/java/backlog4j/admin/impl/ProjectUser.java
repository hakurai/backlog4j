package backlog4j.admin.impl;

import backlog4j.User;

import java.util.Map;

/**
 * @author eguchi
 */
public final class ProjectUser implements User {

    private final Integer id;
    private final String  userId;
    private final String  name;

    public ProjectUser(Map<String, Object> map) {

        id = (Integer) map.get("id");
        name = (String) map.get("name");
        userId = (String) map.get("user_id");

    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLang() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getUpdatedOn() {
        throw new UnsupportedOperationException();
    }
}
