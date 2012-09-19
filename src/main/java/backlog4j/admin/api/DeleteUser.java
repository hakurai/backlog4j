package backlog4j.admin.api;

import backlog4j.BacklogAdminClient;
import backlog4j.BacklogException;
import backlog4j.admin.impl.UserEx;

import java.util.Map;

/**
 * @author eguchi
 */
public class DeleteUser implements BacklogAdminCommand<UserEx> {

    private final BacklogAdminClient client;
    private Integer id;

    public DeleteUser(BacklogAdminClient client) {
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public DeleteUser setId(Integer id) {
        this.id = id;

        return this;
    }

    private void checkParameters() {
        if (getId() == null) {
            throw new BacklogException("id is required");
        }
    }

    @Override
    public UserEx execute() {
        checkParameters();

        Object res = client.execute(BACKLOG_ADMIN_DELETE_USER, getId());

        return new UserEx((Map<String, Object>) res);
    }
}