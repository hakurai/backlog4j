package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.User;
import backlog4j.UserIcon;

import java.util.Map;

/**
 * @author eguchi
 */
public class GetUserIcon implements BacklogCommand<UserIcon> {

    private final BacklogClient client;
    private Integer id;

    public GetUserIcon(BacklogClient client) {
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public GetUserIcon setId(Integer id) {
        this.id = id;

        return this;
    }

    public UserIcon execute() {
        Object res = client.execute(BACKLOG_GET_USER_ICON, id);

        return new UserIcon((Map<String, Object>) res);
    }
}
