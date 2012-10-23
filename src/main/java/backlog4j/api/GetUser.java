package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.User;
import backlog4j.impl.UserImpl;

import java.util.Map;

/**
 * @author eguchi
 */
public class GetUser implements BacklogCommand<User> {

    private final BacklogClient client;
    private Integer id;
    private String userId;

    public GetUser(BacklogClient client) {
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public GetUser setId(Integer id) {
        this.id = id;

        return this;
    }

    public String getUserId() {
        return userId;
    }

    public GetUser setUserId(String userId) {
        this.userId = userId;

        return this;
    }

    private void checkParameters() {
        if (getId() == null && getUserId() == null) {
            throw new BacklogException("id is required");
        }
    }

    public User execute() {
        checkParameters();

        Object res;

        if (getId() == null) {
            res = client.execute(BACKLOG_GET_USER, getUserId());

        } else {
            res = client.execute(BACKLOG_GET_USER, getId());

        }

        return UserImpl.create((Map<String, Object>) res);
    }
}
