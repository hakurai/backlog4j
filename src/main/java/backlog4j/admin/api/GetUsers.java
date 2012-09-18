package backlog4j.admin.api;

import backlog4j.BacklogAdminClient;
import backlog4j.admin.UserEx;

import java.util.List;

/**
 * @author eguchi
 */
public class GetUsers implements BacklogAdminCommand<List<UserEx>> {

    private final BacklogAdminClient client;

    public GetUsers(BacklogAdminClient client) {
        this.client = client;
    }

    @Override
    public List<UserEx> execute() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}