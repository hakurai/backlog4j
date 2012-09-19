package backlog4j.admin.api;

import backlog4j.BacklogAdminClient;
import backlog4j.admin.impl.UserEx;
import backlog4j.util.XmlRpcUtil;

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

        Object res = client.execute(BACKLOG_ADMIN_GET_USERS);

        return XmlRpcUtil.toList(UserEx.class, res);
    }

}