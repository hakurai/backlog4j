package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.User;

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

    public User execute() {
        Object res = client.execute(BACKLOG_GET_USER, id);

        return User.create((Map<String, Object>) res);
    }
}
