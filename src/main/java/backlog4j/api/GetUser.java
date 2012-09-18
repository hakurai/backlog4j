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

    private void checkParameters() {
        if (getId() == null) {
            throw new BacklogException("id is required");
        }
    }

    public User execute() {
        checkParameters();
        Object res = client.execute(BACKLOG_GET_USER, id);

        return UserImpl.create((Map<String, Object>) res);
    }
}
