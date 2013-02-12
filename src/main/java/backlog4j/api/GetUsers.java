package backlog4j.api;

import backlog4j.BacklogClient;
import backlog4j.BacklogException;
import backlog4j.User;
import backlog4j.UserList;
import backlog4j.impl.UserImpl;
import backlog4j.impl.UserListImpl;
import backlog4j.util.XmlRpcUtil;

import java.util.List;

/**
 * @author eguchi
 */
public class GetUsers implements BacklogCommand<UserList> {

    private final BacklogClient client;
    private Integer projectId;

    public GetUsers(BacklogClient client) {
        this.client = client;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public GetUsers setProjectId(Integer projectId) {
        this.projectId = projectId;

        return this;
    }

    public UserList execute() {
        if (getProjectId() == null) {
            throw new BacklogException("projectId is required");
        }

        Object res = client.execute(BACKLOG_GET_USERS, getProjectId());

        List<User> userList = XmlRpcUtil.<User>toList(UserImpl.class, res);
        return new UserListImpl(userList);
    }
}
